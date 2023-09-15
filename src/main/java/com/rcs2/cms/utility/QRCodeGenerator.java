/**
 * 
 */
package com.rcs2.cms.utility;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Date;
import java.util.EnumMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * @author janaka
 *
 */
public class QRCodeGenerator {

	public static void generateQRCodeImage(String text, int width, int height, String filePath)throws WriterException, IOException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.CODABAR, width, height);

		Path path = FileSystems.getDefault().getPath(filePath);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

	}

	public static String getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
		Map<EncodeHintType, Object> hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		hints.put(EncodeHintType.MARGIN, 1); /* default = 4 */
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height,hints);

		ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, "jpg", pngOutputStream);
		byte[] pngData = pngOutputStream.toByteArray();
		

		return new String(Base64.encodeBase64(pngData));
	}

	public static String getTokenText() {
		
		
		return String.valueOf(new Date().getTime());
	}
	
	public static String getBarCodeImage(String text, int width, int height) throws WriterException, IOException {
		Map<EncodeHintType, Object> hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		hints.put(EncodeHintType.MARGIN, 4); /* default = 4 */
		//BitMatrix bitMatrix1= new CodaBarWriter().encode(text, BarcodeFormat.CODABAR, width, height);
		//BitMatrix bitMatrix1= new PDF417Writer().encode(text, BarcodeFormat.PDF_417, width, height);
	   // BitMatrix bitMatrix1 = new EAN13Writer().encode(text, BarcodeFormat.EAN_13, width, height);
	    BitMatrix bitMatrix1 = new Code128Writer().encode(text, BarcodeFormat.CODE_128, width, height,hints);
	    
		ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix1, "jpg", pngOutputStream);
		byte[] pngData = pngOutputStream.toByteArray();
		
		//System.out.println(pngData.length);
		return new String(Base64.encodeBase64(pngData));
	}
	
}


