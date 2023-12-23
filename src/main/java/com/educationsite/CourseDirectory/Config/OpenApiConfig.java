package com.educationsite.CourseDirectory.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Aman",
                        email = "aman.sahu1171@gmail.com",
                        url = ""
                ),
                description = "Course Directory Api",
                title = "Course Directory App",
                version = "1.0",
                license = @License(
                        name = "Licence name",
                        url = ""
                ),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Dev ENV",
                        url = "http://localhost:8090"
                ),
                @Server(
                        description = "Test ENV",
                        url = ""
                ),
                @Server(
                        description = "PROD ENV",
                        url = ""
                )
        }
)
public class OpenApiConfig {
}
