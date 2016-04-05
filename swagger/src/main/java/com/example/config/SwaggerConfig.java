package com.example.config;

import com.example.rest.TaskController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@ComponentScan(basePackageClasses = {
        TaskController.class
})
public class SwaggerConfig {

    @Autowired
    private Environment environment;

    @Bean
    public Docket enovationAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                //.host(host)
                .groupName("Tasks project")
                .apiInfo(publicInfo())
                .directModelSubstitute(LocalTime.class, String.class)
                .directModelSubstitute(LocalDate.class, String.class)
                .directModelSubstitute(LocalDateTime.class, String.class)
                .directModelSubstitute(XMLGregorianCalendar.class, Date.class)
                .useDefaultResponseMessages(false)
                .select()
                .paths(regex("/tasks.*"))
                .build();
    }

    private ApiInfo publicInfo() {
        return new ApiInfoBuilder()
                .title("Tasks API")
                .description("API for Tasks")
                .termsOfServiceUrl("http://test.com/termsofservice")
                .version(environment.getProperty("info.app.version"))
                .build();
    }

}
