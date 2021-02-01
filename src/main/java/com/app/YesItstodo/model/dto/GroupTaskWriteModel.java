package com.app.YesItstodo.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GroupTaskWriteModel {
    private String description;
    private LocalDateTime deadline;
}
