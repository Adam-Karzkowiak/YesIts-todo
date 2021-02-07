package com.app.YesItstodo.service;

import com.app.YesItstodo.configuration.TaskConfigurationProperties;
import com.app.YesItstodo.data.project.ProjectRepository;
import com.app.YesItstodo.data.taskGroup.TaskGroupRepository;
import com.app.YesItstodo.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Project> readAll() {
        return projectRepository.findAll()
                .stream()
                .map(Project::new)
                .collect(Collectors.toList());
    }

    public Project create(Project saveEntity) {
        Project result = projectRepository.save(saveEntity);
        return result;
    }
}