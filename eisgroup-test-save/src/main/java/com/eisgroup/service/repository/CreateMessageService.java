package com.eisgroup.service.repository;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.eisgroup.test.service.domain.Message;

public class CreateMessageService {

    @Autowired
    private MessageRepository messageRepository;

    public UUID execute(Message message) {
    	message.setId(UUID.randomUUID());
        messageRepository.save(message);
        return message.getId();
    }
}
