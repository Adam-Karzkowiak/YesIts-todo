package com.app.YesItstodo.model.dto;

import com.app.YesItstodo.model.Task;
import com.app.YesItstodo.model.TaskGroup;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class GroupReadModel {
    private String description;
    private LocalDateTime deadline;
    private Set<GroupTaskReadModel> tasks;


    public GroupReadModel(TaskGroup source) {
        description = source.getDescription();
        source.getTasks().stream()
                .map(Task::getDeadline)
                .max(LocalDateTime::compareTo)
                .ifPresent(date->deadline=date);
        tasks=source.getTasks()
                .stream()
                .map(GroupTaskReadModel::new)
                .collect(Collectors.toSet());
    }
}
