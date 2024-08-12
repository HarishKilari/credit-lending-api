package com.cg.hackathon.training;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi groupedOpenApi() {
        return GroupedOpenApi.builder().group("LendingAPI_V1")
                        .packagesToScan("com.cg.hackathon.training.controller").build();
    }
}
