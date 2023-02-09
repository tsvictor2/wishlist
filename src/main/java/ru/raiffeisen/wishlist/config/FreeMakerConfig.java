package ru.raiffeisen.wishlist.config;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.nio.charset.StandardCharsets;

@org.springframework.context.annotation.Configuration
public class FreeMakerConfig {

    @Value("${templates.path}")
    private String resourcePath;

    @Bean
    @SneakyThrows
    public Configuration freeMaker() {
        freemarker.template.Configuration freemarkerConfiguration =
                new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_28);
        freemarkerConfiguration.setClassForTemplateLoading(this.getClass(), resourcePath);
        freemarkerConfiguration.setDefaultEncoding(StandardCharsets.UTF_8.name());
        return freemarkerConfiguration;
    }

    @Bean
    @SneakyThrows
    public Template statusTemplate(Configuration freeMaker) {
        return freeMaker.getTemplate("status.ftl");
    }
}
