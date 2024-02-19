package com.gfg.eventdrivendemo.publisher;

import com.gfg.eventdrivendemo.MessageConfiguration;
import com.gfg.eventdrivendemo.dto.CourseDTO;
import com.gfg.eventdrivendemo.service.CourseService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutorial")
public class RegisterPublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    MessageConfiguration messageConfiguration;

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {
        CourseDTO createdCourse = courseService.createCourse(courseDTO);
        rabbitTemplate.convertAndSend(messageConfiguration.EXCHANGE,messageConfiguration.ROUTINGKEY,createdCourse);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);

    }


}
