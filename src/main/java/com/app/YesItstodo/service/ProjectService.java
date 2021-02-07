package com.app.YesItstodo.service;

import com.app.YesItstodo.configuration.TaskConfigurationProperties;
import com.app.YesItstodo.data.project.ProjectRepository;
import com.app.YesItstodo.data.taskGroup.TaskGroupRepository;
import com.app.YesItstodo.model.Project;
import com.app.YesItstodo.model.Task;
import com.app.YesItstodo.model.TaskGroup;
import com.app.YesItstodo.model.dto.group.GroupReadModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        return projectRepository.findAll();
    }

    public Project create(Project saveEntity) {
        return projectRepository.save(saveEntity);
    }

    public GroupReadModel createGroup(int projectId, LocalDateTime deadline) {
        if (!configurationProperties.getTemplate().isAllowMultipleTasks() && groupRepository.existsByDoneIsFalseAndProject_Id(projectId)) {
            throw new IllegalStateException("Only one undone group from project is allowed");
        }
        TaskGroup result = projectRepository.findById(projectId).map(project -> {
            var targetGroup = new TaskGroup();
            targetGroup.setDescription(project.getDescription());
            targetGroup.setTasks(project.getSteps()
                    .stream()
                    .map(projectStep ->
                            new Task(projectStep.getDescription(), deadline.plusDays(projectStep.getDaysToDeadline())))
                    .collect(Collectors.toSet()));
            return targetGroup;
        }).orElseThrow(() -> new IllegalArgumentException("Project with given id not found"));
        return new GroupReadModel(result);
    }
}