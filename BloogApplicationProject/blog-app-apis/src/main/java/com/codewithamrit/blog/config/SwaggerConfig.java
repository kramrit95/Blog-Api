package com.codewithamrit.blog.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	public static final String AUTHORRIZATION_HEADER="Authorization";
	private ApiKey apiKeys()
	{
		return new ApiKey("JWT", AUTHORRIZATION_HEADER, "header");
	}
	private List<SecurityContext> securityContexts()
	{
		return Arrays.asList(SecurityContext.builder().securityReferences(sf()).build());
	}
	
	
	private List<SecurityReference> sf()
	{
	  AuthorizationScope scope=new AuthorizationScope("global","accese verything");
			  return Arrays.asList(new SecurityReference("JWT",new AuthorizationScope[] {
					  scope
			  }));
	}
	@Bean
	public Docket api() {
		
		
		
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getInfo())
				
				.securityContexts(securityContexts())
				.securitySchemes(Arrays.asList(apiKeys()))
				.select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo getInfo() {
		return new ApiInfo("Blog- application:Backend Programme ","This project is develope by Amrit" ,"1.0","Terms and  Api",new springfox.documentation.service.Contact("amrit","https://in.search.yahoo.com/search?fr=mcafee&type=E210IN714G0&p=kramrit95", "kramrit95@gmail.com"),"Licenes of Apis" ,"Api licenes URL",Collections.emptyList());

	}

}
