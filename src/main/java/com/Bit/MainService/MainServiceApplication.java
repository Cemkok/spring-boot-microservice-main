package com.Bit.MainService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
public class MainServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainServiceApplication.class, args);
		
	}

	  @Bean public Docket api() 
	  { return new Docket(DocumentationType.SWAGGER_2)
	  .select() 
	  
	 //RequestHandlerSelectors.any() yaparak default controllers dahil edebiliriz
	  .apis(RequestHandlerSelectors.basePackage("com.Bit.MainService"))
	 //Ve aşağıdakini ekleyerek.
	  .paths(PathSelectors.any()) .build(); }
	
	
}
