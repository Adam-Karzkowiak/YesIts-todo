package com.app.YesItstodo.data.task;

import com.app.YesItstodo.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface TaskRepository {
    List<Task> findAll();

    Optional<Task> findById(Integer id);

    boolean existsById(Integer id);

    boolean existsByDoneIsFalseAndGroup_Id(Integer groupId);

    Page<Task> findAll(Pageable page);

    List<Task> findByDone(boolean done);

    Task save(Task entity);

    void deleteById(Integer id);


}
