package com.app.YesItstodo.service;

import com.app.YesItstodo.configuration.TaskConfigurationProperties;
import com.app.YesItstodo.data.project.ProjectRepository;
import com.app.YesItstodo.data.taskGroup.TaskGroupRepository;
import com.app.YesItstodo.model.Project;
import com.app.YesItstodo.model.dto.group.GroupReadModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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
        return projectRepository.findAll();
    }

    public Project create(Project saveEntity) {
        Project result = projectRepository.save(saveEntity);
        return result;
    }

//    public GroupReadModel createGroup(int projectId, LocalDateTime deadline) {
//        Optional<Project> result = projectRepository.findById(projectId);
//        result.stream().map(Project::getGroups)
//                .map(taskGroups -> groupRepository.existsByDoneIsFalseAndProject_Id(projectId));
//        configurationProperties.
//
//    }
}