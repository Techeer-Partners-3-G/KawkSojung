package com.example.Techeer_Partnerss.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class WebConfig {

    @Bean
    public OpenAPI api() {
        Info info = new Info()
                .title("Techeer Partners API")
                .version("v1")
                .description("API Documentation for Techeer Partners");
//수정
        return new OpenAPI().components(new Components()).info(info);
    }
}
