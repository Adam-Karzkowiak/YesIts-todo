package com.app.YesItstodo.model.dto.group;

import com.app.YesItstodo.model.TaskGroup;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
public class GroupWriteModel {
    private String description;
    private Set<GroupTaskWriteModel> tasks;

    public TaskGroup toGroup(){
        var result = new TaskGroup();
        result.setDescription(description);
        result.setTasks(
                tasks.stream()
                        .map(GroupTaskWriteModel::toTask)
                        .collect(Collectors.toSet()));
    return result;
    }
}
