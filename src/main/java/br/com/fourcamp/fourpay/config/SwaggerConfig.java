package br.com.fourcamp.fourpay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI fourPayApi() {
		return new OpenAPI()
				.info(new Info().title("FourPay")
				.description("API REST do projeto final do FourCamp")
				.version("v1.0")
				.license(new io.swagger.v3.oas.models.info.License().name("Apache 2.0").url("http://springdoc.org")));
	}
}