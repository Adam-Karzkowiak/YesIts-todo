package com.app.YesItstodo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
    private int id;
    private String description;
    private boolean done;
}
