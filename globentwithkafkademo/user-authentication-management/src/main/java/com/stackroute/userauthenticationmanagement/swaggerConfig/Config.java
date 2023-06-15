package com.stackroute.userauthenticationmanagement.swaggerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class Config {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfo("Authentication-Service", "Authentication service for Globent", "1.0", "http://localhost:8763/api/auth"
                        , new Contact("name", "url", "saurabh.jha@globallogic.com"), "opensource", "", Collections.emptyList()));
    }
}
