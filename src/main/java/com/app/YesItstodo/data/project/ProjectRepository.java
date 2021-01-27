package com.app.YesItstodo.data.project;

import com.app.YesItstodo.model.Project;

import java.util.List;
import java.util.Optional;

interface ProjectRepository {

    List<Project> findAll();

    Optional<Project> findById(Integer id);

    Project save(Project entity);
}
