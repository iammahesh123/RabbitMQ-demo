package com.gfg.eventdrivendemo.consumer;

import com.gfg.eventdrivendemo.MessageConfiguration;
import com.gfg.eventdrivendemo.dto.CourseDTO;
import com.gfg.eventdrivendemo.publisher.RegisterPublisher;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseAdmin {

    @Autowired
    MessageConfiguration messageConfiguration;

    @RabbitListener(queues = MessageConfiguration.QUEUE)
   public void consumerMessagefromQueue(CourseDTO createdCourse ) {
       System.out.println("Course reciveved:"+createdCourse);
   }
}
