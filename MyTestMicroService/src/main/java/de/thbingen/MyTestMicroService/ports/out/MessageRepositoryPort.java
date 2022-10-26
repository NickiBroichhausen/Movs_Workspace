package de.thbingen.MyTestMicroService.ports.out;

import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepositoryPort {

  void storeMessage(String msg);
}
