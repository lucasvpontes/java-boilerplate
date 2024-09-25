package com.java.boilerplate;

import com.java.boilerplate.infrastructure.config.AppConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class JavaBoilerplateApplication {

	public static void main(String[] args) {
    new SpringApplicationBuilder(AppConfig.class).registerShutdownHook(true).run(args);
	}
}
