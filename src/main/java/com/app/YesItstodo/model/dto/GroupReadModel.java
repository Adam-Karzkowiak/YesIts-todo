package com.app.YesItstodo.model.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class GroupReadModel {
    private String description;
    private LocalDateTime deadline;
    private Set<GroupTaskReadModel> tasks;
}
