package com.alberto.Demo.Alberto.config;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    // Configura un grupo de API para Swagger
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")  // Nombre del grupo de APIs, por ejemplo "public"
                .packagesToScan("com.alberto.Demo")
                // Escanea los paquetes para encontrar los controladores
                .pathsToMatch("/**")  // Expone todas las rutas de tu API
                .build();
    }
}
