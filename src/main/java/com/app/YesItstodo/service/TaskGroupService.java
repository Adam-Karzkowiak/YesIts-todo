package com.app.YesItstodo.service;

import com.app.YesItstodo.data.taskGroup.TaskGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskGroupService {
    private TaskGroupRepository repository;

    @Autowired
    TaskGroupService(final TaskGroupRepository repository) {
        this.repository = repository;
    }


}
