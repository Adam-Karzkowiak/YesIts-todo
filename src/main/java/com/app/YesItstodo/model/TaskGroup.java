package com.app.YesItstodo.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_groups")
@Data
@NoArgsConstructor
public class TaskGroup {
    @Id
    @GeneratedValue(generator = "incId")
    @GenericGenerator(name = "incId", strategy = "increment")
    private int id;
    @NotBlank(message = "Task groups description must not be empty")
    private String description;
    private boolean done;
    @Embedded
    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private Audit audit = new Audit();


}
