package com.eisgroup.service.repository;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import com.eisgroup.test.service.domain.Message;

public interface MessageRepository extends  CrudRepository<Message, UUID>{

}
