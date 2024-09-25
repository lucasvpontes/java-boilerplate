package com.java.boilerplate.infrastructure.config;


import com.java.boilerplate.infrastructure.util.ObjectMapperUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@ComponentScan({"com.java.boilerplate"})
@Configuration
@EnableAutoConfiguration
public class AppConfig {

  @Bean
  @Primary
  public ObjectMapper objectMapper() {
    return ObjectMapperUtils.getObjectMapper();
  }
}
