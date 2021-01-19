package com.booksinfoservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Soujanya Pagala
 *
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableSwagger2
public class BooksInfoServiceApplication 
{
	 private static final Logger LOGGER = LogManager.getLogger(BooksInfoServiceApplication.class);
	 public static void main(String[] args) {
		 LOGGER.info(" :::::  BooksInfoServiceApplication Started  :::::: ");
		 SpringApplication.run(BooksInfoServiceApplication.class, args);
	 }
	 
	 @Bean
	 public Docket BooksInfo()
	 {
			return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).build();
	 }

}