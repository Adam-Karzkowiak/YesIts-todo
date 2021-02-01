package com.app.YesItstodo.model.dto;

import com.app.YesItstodo.model.Task;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GroupTaskWriteModel {
    private String description;
    private LocalDateTime deadline;

    public Task toTask() {
        return new Task(description, deadline);

    }
}
