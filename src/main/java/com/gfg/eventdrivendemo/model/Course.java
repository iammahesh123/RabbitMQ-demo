package com.gfg.eventdrivendemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    private String id;
    private String tutorialName;
    private String description;

}
