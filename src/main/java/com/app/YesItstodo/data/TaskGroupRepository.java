package com.app.YesItstodo.data;

import com.app.YesItstodo.model.TaskGroup;

import java.util.List;
import java.util.Optional;

public interface TaskGroupRepository {

    List<TaskGroup> findAll();

    Optional<TaskGroup> findById(Integer id);

    TaskGroup save(TaskGroup entity);
}
