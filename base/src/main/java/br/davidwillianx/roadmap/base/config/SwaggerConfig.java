package br.davidwillianx.roadmap.base.config;

import com.sun.deploy.ui.AppInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.davidwillianx.roadmap.base.resources"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(appInfo());
    }

    private ApiInfo appInfo() {
        return new ApiInfoBuilder()
                .title("Base rest API")
                .description("Just a stepUp spring application")
                .contact(new Contact("David Willian", "github.com/davidwillianx", "davidcbsi(at)gmail.com"))
                .version("1.0")
                .termsOfServiceUrl("There is not terms yet")
                .build();
    }
}
