package com.app.YesItstodo.data;

import com.app.YesItstodo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

interface TaskRepository extends JpaRepository<Task,Integer> {
}
