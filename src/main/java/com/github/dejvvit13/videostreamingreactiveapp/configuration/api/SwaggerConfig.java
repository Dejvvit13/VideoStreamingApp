package com.github.dejvvit13.videostreamingreactiveapp.configuration.api;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {
    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "bearerAuth";
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement()
                        .addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name(securitySchemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")))
                .info(new Info()
                        .title(applicationName)
                        .description("API documentation for " + applicationName)
                        .version("1.0.0")
                );
    }

    @Bean
    public GroupedOpenApi customApi() {
        return GroupedOpenApi.builder()
                .group("api")
                .pathsToMatch("/api/**").build();
    }


}
