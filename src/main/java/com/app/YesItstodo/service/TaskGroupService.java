package com.app.YesItstodo.service;

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

    @Autowired
    TaskGroupService(final TaskGroupRepository repository) {
        this.repository = repository;
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

}
