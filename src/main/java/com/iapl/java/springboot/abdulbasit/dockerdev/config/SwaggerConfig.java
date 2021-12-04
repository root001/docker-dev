package com.iapl.java.springboot.abdulbasit.dockerdev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket SwaggerApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.iapl.java.springboot.abdulbasit.dockerdev"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Swagger API Sample Using Spring Boot and swagger",
                "API reference Example By Abdul-Basit",
                "1.0.0",
                "Private API",
                new Contact(
                        "Demo",
                        "http://www.google.com",
                        "info@digitalcreong.com"),
                "API License Closed",
                "http://www.google.com/license",
                Collections.emptyList());
    }
}
