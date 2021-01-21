package com.app.YesItstodo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("task")
@Data
public class TaskConfigurationProperties {
    private Template template;

    @Data
    @Configuration
    @ConfigurationProperties("template")
    public static class Template {
        private boolean allowMultipleTasks;
    }
}
