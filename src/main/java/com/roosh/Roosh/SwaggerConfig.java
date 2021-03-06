package com.roosh.Roosh;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SPRING_WEB)
                .select()                 
                .apis(RequestHandlerSelectors.basePackage("com.roosh.controller"))
                .build();
    }
}
