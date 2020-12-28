package com.facebookboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@EnableSwagger2
public class FacebookbootApplication {
	
	  // private static final Logger logger = LoggerFactory.getLogger(FacebookbootApplication.class);


	public static void main(String[] args) {
		//logger.info("this is a info message");
		SpringApplication.run(FacebookbootApplication.class, args);
	}
	
	@Bean
    public Docket productApi() {
       return new Docket(DocumentationType.SWAGGER_2).select()
          .apis(RequestHandlerSelectors.basePackage("com.facebookboot")).build();
    }



}
