package com.app.YesItstodo.controller;

import com.app.YesItstodo.configuration.TaskConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class InfoController {
    private DataSourceProperties dataSource;
    private TaskConfigurationProperties taskConfigurationProperties;

    @Autowired
    InfoController(final DataSourceProperties dataSource, final TaskConfigurationProperties taskConfigurationProperties) {
        this.dataSource = dataSource;
        this.taskConfigurationProperties = taskConfigurationProperties;
    }

    @GetMapping("/info/url")
    String url() {
        return dataSource.getUrl();
    }

    @GetMapping("/info/prop")
    boolean myProp() {
        return taskConfigurationProperties.getTemplate().isAllowMultipleTasks();
    }
}
