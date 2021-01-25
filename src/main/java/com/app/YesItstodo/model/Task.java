package com.app.YesItstodo.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(generator = "incId")
    @GenericGenerator(name = "incId", strategy = "increment")
    private int id;

    @NotBlank(message = "Tasks description must not be empty")
    private String description;
    private boolean done;
    private LocalDateTime deadline;

    @Embedded
    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private Audit audit = new Audit();

    @ManyToOne
    private TaskGroup group;

    public void updateFrom(final Task source) {
        description = source.description;
        done = source.done;
        deadline = source.deadline;

    }

}
