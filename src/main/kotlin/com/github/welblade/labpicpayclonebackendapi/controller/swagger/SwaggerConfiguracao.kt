package com.github.welblade.labpicpayclonebackendapi.controller.swagger

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.ApiKey
import springfox.documentation.service.SecurityScheme
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConfiguracao {
	@Value("\${spring.api.version}")
	private val versaoAplicacao: String? = null

	@Bean
	fun productApi(): Docket? {
		return Docket(DocumentationType.SWAGGER_2).select()
			.apis(RequestHandlerSelectors.basePackage("com.github.welblade.labpicpayclonebackendapi"))
			.paths(PathSelectors.any())
			.build()
			.apiInfo(apiInfo()).useDefaultResponseMessages(false)
			.securitySchemes(listOf(apiKey()) as List<SecurityScheme>?)
	}

	fun apiInfo(): ApiInfo? {
		return ApiInfoBuilder()
			.title("PicPayClone API")
			.description("Estrutura de uma API RestFull com Spring Boot para simular funcionalidades do PicPay")
			.version(versaoAplicacao)
			.build()
	}

	private fun apiKey(): ApiKey {
		return ApiKey("Authorization", "Authorization", "header")
	}
}