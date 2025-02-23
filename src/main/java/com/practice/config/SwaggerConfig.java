package com.practice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Documentacion de Api Microservicio de Clients",
                description = "Documentacion de Api Microservicio de  Clients",
                version = "1.0.0"
        ),
        servers = {
                @Server(
                        description = "Local Server",
                        url = "http://localhost:8080/api/v1/client"
                )
        }
)
public class SwaggerConfig {

}