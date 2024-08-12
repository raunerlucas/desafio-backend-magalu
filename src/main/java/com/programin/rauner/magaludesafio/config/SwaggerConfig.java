package com.programin.rauner.magaludesafio.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI desafioMagaluOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Desafio Magalu - Serviço de Mensageria")
                        .version("1.0.0")
                        .description("API para agendamento de mensagens (email, SMS, push, Whatsapp) do desafio da Magalu"));
    }

}
