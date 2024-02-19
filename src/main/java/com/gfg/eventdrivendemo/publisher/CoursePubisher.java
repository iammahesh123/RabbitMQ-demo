package com.gfg.eventdrivendemo.publisher;

import com.gfg.eventdrivendemo.MessageConfiguration;
import com.gfg.eventdrivendemo.dto.CourseDTO;
import com.gfg.eventdrivendemo.dto.StudentDTO;
import com.gfg.eventdrivendemo.service.CourseService;
import com.gfg.eventdrivendemo.service.StudentService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class CoursePubisher {

    @Autowired
    private StudentService studentService;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    MessageConfiguration messageConfiguration;

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO createdStudent = studentService.createStudent(studentDTO);
        rabbitTemplate.convertAndSend(messageConfiguration.EXCHANGE,messageConfiguration.ROUTINGKEY,createdStudent);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

}
