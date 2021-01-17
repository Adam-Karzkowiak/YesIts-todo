package com.app.YesItstodo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task {
    @Id
    private int id;
    private String description;
    private boolean done;

}
