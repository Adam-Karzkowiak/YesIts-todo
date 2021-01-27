package com.app.YesItstodo.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@Entity
@Table(name = "projects")
class Project {
    @Id
    @GeneratedValue(generator = "incId")
    @GenericGenerator(name = "incId", strategy = "increment")
    int id;

    @NotBlank
    String description;

}