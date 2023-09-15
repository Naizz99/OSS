package com.rcs2.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableCaching
@EnableEncryptableProperties
public class Qms3Application {

	public static void main(String[] args) {
		SpringApplication.run(Qms3Application.class, args);
	}
}
