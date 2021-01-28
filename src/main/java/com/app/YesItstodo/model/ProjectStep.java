package com.app.YesItstodo.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "project_steps")
@Data
@NoArgsConstructor
public class ProjectStep {
    @Id
    @GeneratedValue(generator = "incId")
    @GenericGenerator(name = "incId", strategy = "increment")
    private int id;

    @NotBlank
    private String description;
    private int daysToDeadline;

    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

}
