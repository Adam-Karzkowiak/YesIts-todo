package com.app.YesItstodo.controller;

import com.app.YesItstodo.data.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
class TaskController {
    private final TaskRepository repository;

    @Autowired
    TaskController(final TaskRepository repository) {
        this.repository = repository;
    }
}
