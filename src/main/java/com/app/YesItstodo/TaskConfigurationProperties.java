package com.app.YesItstodo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("task")
@Data
class TaskConfigurationProperties {
    private boolean allowMultipleTasksFromTemplate;

}
