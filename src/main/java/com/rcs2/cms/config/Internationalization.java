/**
 * 
 */
package com.rcs2.cms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * @author janaka
 *
 */
@Configuration
public class Internationalization implements WebMvcConfigurer{

	@Bean
	   public LocaleResolver localeResolver() {
		return new CookieLocaleResolver();
			/*
			 * SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
			 * sessionLocaleResolver.setDefaultLocale(Locale.ENGLISH); return
			 * sessionLocaleResolver;
			 */
	   }
	   @Bean
	   public LocaleChangeInterceptor localeChangeInterceptor() {
	      LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
	      localeChangeInterceptor.setParamName("lang");
	      return localeChangeInterceptor;
	   }
	   @Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(localeChangeInterceptor());
	   }
}
