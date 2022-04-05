package com.eisgroup.test.save.repository;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import com.eisgroup.test.save.domain.Message;

public interface MessageRepository extends  CrudRepository<Message, UUID>{

}
