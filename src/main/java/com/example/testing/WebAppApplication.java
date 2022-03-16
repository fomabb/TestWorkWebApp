package com.example.testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

@SpringBootApplication
public class WebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAppApplication.class, args);
	}

	@Bean
	public MessageSource messageSource (){
		ResourceBundleMessageSource messageSource  =   new   ResourceBundleMessageSource ();
		messageSource . setBasename( " message_source/messages " );
		messageSource . setDefaultEncoding( StandardCharsets. UTF_8 . name());
		messageSource . setDefaultLocale( Locale. ENGLISH );
		return  messageSource;
	}

	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor (){
		return   new   MethodValidationPostProcessor ();
	}
}
