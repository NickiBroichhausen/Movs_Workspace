package de.thbingen.MyRESTbasedMS;

import de.thbingen.MyRESTbasedMS.adapters.out.PostgresStorage;
import de.thbingen.MyRESTbasedMS.ports.out.MessageRepositoryPort;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyRESTbasedMSApplication {

  @Bean
  public MessageRepositoryPort createMessageRepositoryAdapter() {
    return new PostgresStorage();
  }

  public static void main(String[] args) {
    SpringApplication.run(MyRESTbasedMSApplication.class, args);
  }

}
