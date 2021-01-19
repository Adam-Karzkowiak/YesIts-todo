package com.app.YesItstodo.data;

import com.app.YesItstodo.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface TaskRepository {
    List<Task> findAll();

    Optional<Task> findById(Integer id);

    boolean existsById(Integer id);

    Page<Task> findAll(Pageable page);

    List<Task> findByDone(@Param("state") boolean done);

    Task save(Task entity);


}
