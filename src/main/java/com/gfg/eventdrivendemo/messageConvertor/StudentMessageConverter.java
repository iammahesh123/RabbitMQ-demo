package com.gfg.eventdrivendemo.messageConvertor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gfg.eventdrivendemo.dto.StudentDTO;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class StudentMessageConverter implements MessageConverter {

    private final ObjectMapper objectMapper;

    public StudentMessageConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Message toMessage(Object object, MessageProperties messageProperties) throws org.springframework.messaging.converter.MessageConversionException {
        try {
            String jsonString = objectMapper.writeValueAsString(object);
            return new Message(jsonString.getBytes(), messageProperties);
        } catch (JsonProcessingException e) {
            throw new org.springframework.messaging.converter.MessageConversionException("Error converting object to JSON", e);
        }
    }

    @Override
    public Object fromMessage(Message message) throws org.springframework.messaging.converter.MessageConversionException {
        try {
            String jsonString = new String(message.getBody());
            return objectMapper.readValue(jsonString, StudentDTO.class);
        } catch (Exception e) {
            throw new org.springframework.messaging.converter.MessageConversionException("Error converting JSON to object", e);
        }
    }
}


