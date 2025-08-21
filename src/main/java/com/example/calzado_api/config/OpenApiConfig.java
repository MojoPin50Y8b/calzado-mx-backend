package com.example.calzado_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI().info(new Info()
      .title("Calzado API")
      .version("v1")
      .description("CRUD de marcas y calzado"));
  }
}
