package com.app.YesItstodo.data.project;

import com.app.YesItstodo.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlProjectRepository extends ProjectRepository, JpaRepository<Project,Integer> {
}
