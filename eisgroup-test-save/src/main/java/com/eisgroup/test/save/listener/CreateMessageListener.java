package com.eisgroup.test.save.listener;

import com.eisgroup.test.save.domain.MessageJson;
import com.eisgroup.test.save.domain.Message;
import com.eisgroup.test.save.repository.CreateMessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.UUID;

@Service
public class CreateMessageListener {

    @Autowired
    private CreateMessageService createMessageService;

    @KafkaListener(topics = "${kafka.topic.request-topic}")
    @SendTo
    public String listen(String json) throws InterruptedException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        MessageJson messageJson = mapper.readValue(json, MessageJson.class);

        UUID uuid = createMessageService.execute(Message
                .builder()
                .message(messageJson.getContent())
                .build()
        );

        messageJson.setUuid(uuid.toString());

        return mapper.writeValueAsString(messageJson);
    }
}
