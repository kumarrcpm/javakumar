package com.example.demo.auth.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		info=@Info(
				contact = @Contact(
						name="Kumar",
						email="rkumar@chn.aithent.com",
						url="https://www.aithent.com/"
						),
				description = "AFM Documentation",
				title = "AFM Project API's",
				version="1.0",
				license = @License(
						name="License Name",
						url = "https://some-url.com"
							),
				termsOfService = "Terms Of Service"				
				),
				servers = {
						@Server(
								description = "Local ENV",
								url = "http://localhost:8080"
								)
				}
		)

@SecurityScheme(
name="bearerAuth",
description="JWT Auth Description",
scheme="bearer",
type= SecuritySchemeType.HTTP,
bearerFormat="JWT",
in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {

}
