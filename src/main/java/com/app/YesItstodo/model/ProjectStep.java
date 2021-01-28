package com.app.YesItstodo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "project_steps")
public class ProjectStep {
    @Id
    @GeneratedValue(generator = "incId")
    @GenericGenerator(name = "incId", strategy = "increment")
    private int id;

    @NotBlank
    private String description;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

}
