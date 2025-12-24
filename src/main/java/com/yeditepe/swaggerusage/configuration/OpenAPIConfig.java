package com.yeditepe.swaggerusage.configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(
                new Info().title("Student API")
                        .contact(new Contact()
                                .url("https:/example.com/")
                                .email("contact@example.com")
                                )
                        .version("1.0")
        );
    }
}
