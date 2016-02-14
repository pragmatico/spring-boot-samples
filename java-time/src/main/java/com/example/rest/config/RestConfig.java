package com.example.rest.config;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@Configuration
public class RestConfig {

    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {
        return new Jackson2ObjectMapperBuilder()
                .indentOutput(true)
                .dateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
    }

    @Bean
    public CustomEditorConfigurer customEditorConfigurer(PropertyEditorRegistrar propertyEditorRegistrar) {
        CustomEditorConfigurer ret = new CustomEditorConfigurer();
        ret.setPropertyEditorRegistrars(new PropertyEditorRegistrar[]{propertyEditorRegistrar});
        return ret;
    }

    @Bean
    public PropertyEditorRegistrar propertyEditorRegistrar() {
        return r -> {
            r.registerCustomEditor(LocalDateTime.class, new LocalDateTimePropertyEditor());
        };
    }
}
