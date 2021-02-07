package com.app.YesItstodo.service;

import com.app.YesItstodo.data.task.TaskRepository;
import com.app.YesItstodo.data.taskGroup.TaskGroupRepository;
import com.app.YesItstodo.model.TaskGroup;
import com.app.YesItstodo.model.dto.group.GroupReadModel;
import com.app.YesItstodo.model.dto.group.GroupWriteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskGroupService {
    private TaskGroupRepository repository;
    private TaskRepository taskRepository;

    @Autowired
    TaskGroupService(final TaskGroupRepository repository, final TaskRepository taskRepository) {
        this.repository = repository;
        this.taskRepository = taskRepository;
    }


    public GroupReadModel createGroup(GroupWriteModel groupWriteModel) {
        TaskGroup result = repository.save(groupWriteModel.toGroup());
        return new GroupReadModel(result);
    }

    public List<GroupReadModel> readAll() {
        return repository.findAll()
                .stream()
                .map(GroupReadModel::new)
                .collect(Collectors.toList());
    }

    public void toggleGroup(int groupId) {
        if (taskRepository.existsByDoneIsFalseAndGroup_Id(groupId)) {
            throw new IllegalStateException("Group has undone tasks.");
        }
        TaskGroup result = repository.findById(groupId)
                .orElseThrow(() -> new IllegalArgumentException("TaskGroup not found"));
        result.setDone(!result.isDone());
    }
}
