package com.example.swagger.config;

import  static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration

@EnableSwagger2
public class BookConfig {
	
	@Bean
	public Docket postApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("My Swagger").apiInfo(apiInfo()).select()
				.paths(regex("/api.*")).build();
		
	}
	private ApiInfo apiInfo()  {
		return new ApiInfoBuilder().title("Insurance Api")
				.description("This is my first swagger")
				.termsOfServiceUrl("www.Swagger.com")
				.license("Swager1234")
				.licenseUrl("www.swaggerurl").version("alpha1.2").build();
	} 
/* Sami	private ApiKey apiKey() { 
	    return new ApiKey("JWT", "Authorization", "header"); 
	}

	private SecurityContext securityContext() { 
	    return SecurityContext.builder().securityReferences(defaultAuth()).build(); 
	} 

	private List<SecurityReference> defaultAuth() { 
	    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything"); 
	    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1]; 
	    authorizationScopes[0] = authorizationScope; 
	    return Arrays.asList(new SecurityReference("JWT", authorizationScopes)); 
	}
	
	@Bean
	public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)
	      .apiInfo(apiInfo())
	      .securityContexts(Arrays.asList(securityContext()))
	      .securitySchemes(Arrays.asList(apiKey()))
	      .select()
	      .apis(RequestHandlerSelectors.any())
	      .paths(PathSelectors.any())
	      .build();
	}
	
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "My REST API",
	      "Some custom description of API.",
	      "1.0",
	      "Terms of service",
	      new Contact("Maan Sarovar", "www.maansarovar.com", "maanrsa001@gmail.com"),
	      "License of API",
	      "API license URL",
	      Collections.emptyList());
	} */

	

}
