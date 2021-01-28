package com.app.YesItstodo.model;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(generator = "incId")
    @GenericGenerator(name = "incId", strategy = "increment")
    int id;

    @NotBlank
    String description;

    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "project")
    private Set<TaskGroup> groups;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "project")
    private Set<ProjectStep> steps;

}
