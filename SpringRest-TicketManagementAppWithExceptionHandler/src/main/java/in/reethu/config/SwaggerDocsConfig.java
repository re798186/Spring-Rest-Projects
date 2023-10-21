package in.reethu.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
public class SwaggerDocsConfig {

	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2)// UI Screen type

		.select() // to specify RestControllers
		.apis(RequestHandlerSelectors.basePackage("in.reethu.controller"))// base packages for// RestController

		.paths(PathSelectors.regex("/api/tourist.*"))// To specifythe request paths

		.build()// build the docket object
		.useDefaultResponseMessages(true)
		.apiInfo(getApiInfo());

		}

	private ApiInfo getApiInfo() {
		Contact contact = new Contact("reethu", "http://www.wipro.com", "reethu.thapasya@gmail.com");

		return new ApiInfo("TouristInfo", "Gives information about tourist activities", "3.4.RELEASE",
				"http:www.wipro.com/license", contact, "GNU PUBLIC", "http://apache.org/license/guru",
				Collections.emptyList());

	}
}
