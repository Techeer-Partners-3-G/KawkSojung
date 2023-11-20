package com.example.Techeer_Partnerss.config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
//@EnableSwagger2
@OpenAPIDefinition
public class WebConfig {

    @Bean
    public OpenAPI api(){
        Info info = new Info().title("").version("v3").description("aaa");

        return new OpenAPI().components(new Components()).info(info);
    }

}
