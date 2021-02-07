package com.app.YesItstodo.service;

import com.app.YesItstodo.configuration.TaskConfigurationProperties;
import com.app.YesItstodo.data.project.ProjectRepository;
import com.app.YesItstodo.data.taskGroup.TaskGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private TaskGroupRepository groupRepository;
    private ProjectRepository projectRepository;
    private TaskConfigurationProperties configurationProperties;


    @Autowired
    ProjectService(final TaskGroupRepository groupRepository, final ProjectRepository projectRepository, final TaskConfigurationProperties configurationProperties) {
        this.groupRepository = groupRepository;
        this.projectRepository = projectRepository;
        this.configurationProperties = configurationProperties;
    }
}
