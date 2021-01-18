package com.app.YesItstodo.data;

import com.app.YesItstodo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "todos")
interface TaskRepository extends JpaRepository<Task,Integer> {
}
