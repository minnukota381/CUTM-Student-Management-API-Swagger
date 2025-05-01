package com.hm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI cutmOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("CUTM Student API")
                .description("API documentation for CUTM Student Management")
                .version("1.0"));
    }
}
