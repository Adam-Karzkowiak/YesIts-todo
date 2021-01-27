package com.app.YesItstodo.data.taskGroup;

import com.app.YesItstodo.model.TaskGroup;
import org.springframework.data.jpa.repository.JpaRepository;

interface SqlTaskGroupRepository extends TaskGroupRepository, JpaRepository<TaskGroup, Integer> {
}
