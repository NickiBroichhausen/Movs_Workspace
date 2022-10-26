package de.thbingen.MyTestMicroService.adapters.out;

import de.thbingen.MyTestMicroService.ports.out.MessageRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;

public class PostgresStorage implements MessageRepositoryPort {

  @Autowired
  private PostgresRepository postgresRepository;

  @Override
  public void storeMessage(String msg) {
    DBMessageDao dbMessageDao = DBMessageDao.of(msg);
    postgresRepository.save(dbMessageDao);
//    System.out.println(msg);
  }
}
