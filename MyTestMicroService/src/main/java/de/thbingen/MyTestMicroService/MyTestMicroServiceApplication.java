package de.thbingen.MyTestMicroService;

import de.thbingen.MyTestMicroService.adapters.out.PostgresStorage;
import de.thbingen.MyTestMicroService.ports.out.MessageRepositoryPort;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyTestMicroServiceApplication {

  @Bean
  public MessageRepositoryPort createMessageRepositoryAdapter() {
    return new PostgresStorage();
  }

  public static void main(String[] args) {
    SpringApplication.run(MyTestMicroServiceApplication.class, args);
  }

}
