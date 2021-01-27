package com.app.YesItstodo.data.taskGroup;

import com.app.YesItstodo.model.TaskGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SqlTaskGroupRepository extends TaskGroupRepository, JpaRepository<TaskGroup, Integer> {

    @Override
    @Query("from TaskGroup group join fetch group.tasks")
    List<TaskGroup> findAll();
}