package com.app.YesItstodo.service;

import com.app.YesItstodo.configuration.TaskConfigurationProperties;
import com.app.YesItstodo.data.project.ProjectRepository;
import com.app.YesItstodo.data.taskGroup.TaskGroupRepository;
import com.app.YesItstodo.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return projectRepository.findAll();
    }

    public Project create(Project saveEntity) {
        return projectRepository.save(saveEntity);
    }

//    public GroupReadModel createGroup(int projectId, LocalDateTime deadline) {
//        Optional<Project> result = projectRepository.findById(projectId);
//        result.stream().map(Project::getGroups)
//                .map(taskGroups -> groupRepository.existsByDoneIsFalseAndProject_Id(projectId));
//        configurationProperties.
//
//    }
}