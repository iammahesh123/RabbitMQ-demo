package com.gfg.eventdrivendemo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    @Id
    String id;
    private String name;
    private String email;
}
