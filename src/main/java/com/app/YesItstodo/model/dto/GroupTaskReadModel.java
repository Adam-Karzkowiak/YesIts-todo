package com.app.YesItstodo.model.dto;

import com.app.YesItstodo.model.Task;
import lombok.Data;

@Data
public class GroupTaskReadModel {
    private String description;
    private boolean done;

    GroupTaskReadModel(Task source) {
        description = source.getDescription();
        done = source.isDone();
    }
}
