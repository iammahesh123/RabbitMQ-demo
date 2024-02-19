package com.gfg.eventdrivendemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    @Id
    String id;
    private String title;
    private String description;
}
