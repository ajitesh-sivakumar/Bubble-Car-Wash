package com.ajitesh.Bubble.Car.Wash.swagger;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT= new Contact("Ajitesh K S","https://www.ajiteshsivakumar.in","iamajitesh@ajiteshsivakumar.in");
	static List<VendorExtension> vendorExtension = new ArrayList();
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Bubble Car Wash", "BCW Docs", "1.1", "urn:toc", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", vendorExtension);
	static Logger logger = LogManager.getLogger(SwaggerConfig.class);

	@Bean
	public Docket api() {
		logger.info("Swagger Started");
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO);
	}
}
