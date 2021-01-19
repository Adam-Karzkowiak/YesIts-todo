package com.app.YesItstodo.data;

import com.app.YesItstodo.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    List<Task> findAll();

    Optional<Task> findById(Integer id);

    Task save(Task entity);
}
