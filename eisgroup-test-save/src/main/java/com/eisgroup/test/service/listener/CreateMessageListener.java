package com.eisgroup.test.service.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

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
                .message(messageJson.getMessage())
                .build()
        );

        messageJson.setUuid(uuid.toString());

        return mapper.writeValueAsString(messageJson);
    }
}
