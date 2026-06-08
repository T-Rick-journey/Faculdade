package com.faculdade.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

import org.springframework.context.annotation.Bean;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .addServersItem(new Server().url("/concorrencia-bd").description("Server de desenvolvimento"))
                .info(new Info()
                        .title("API de Concorrência em Banco de Dados")
                        .version("1.0.0")
                        .description("API para testes de concorrência e versionamento de contas bancárias")
                        .contact(new Contact()
                                .name("Faculdade")
                                .url("http://localhost:8080/concorrencia-bd")));
    }
}
