package com.eisgroup.test.save.repository;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.eisgroup.test.save.domain.Message;

public class CreateMessageService {

    @Autowired
    private MessageRepository messageRepository;

    public UUID execute(Message message) {
    	message.setId(UUID.randomUUID());
        messageRepository.save(message);
        return message.getId();
    }
}
