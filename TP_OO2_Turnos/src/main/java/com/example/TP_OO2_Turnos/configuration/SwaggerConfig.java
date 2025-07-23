package com.example.TP_OO2_Turnos.configuration;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
	
	 private SecurityScheme createBasicScheme() {
	        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
	            .scheme("basic");
	    }
	
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
        	.addSecurityItem(new SecurityRequirement()
        			.addList("BasicAuth"))
        	.components(new Components()
        			.addSecuritySchemes("BasicAuth",createBasicScheme()))
            .info(new Info()
                .title("API Sistema de Turnos")
                .version("1.0")
                .description("Documentación de la API para el sistema de turnos"));
    }
}