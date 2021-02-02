package com.app.YesItstodo.model.dto;

import lombok.Data;

import java.util.Set;

@Data
public class GroupWriteModel {
    private String description;
    private Set<GroupTaskWriteModel> tasks;


}
