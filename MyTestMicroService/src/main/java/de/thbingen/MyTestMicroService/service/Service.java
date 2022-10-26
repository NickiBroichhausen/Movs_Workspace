package de.thbingen.MyTestMicroService.service;

import de.thbingen.MyTestMicroService.adapters.out.PostgresStorage;
import de.thbingen.MyTestMicroService.ports.in.HttpmsPort;
import de.thbingen.MyTestMicroService.ports.out.MessageRepositoryPort;

@org.springframework.stereotype.Service
public class Service implements HttpmsPort{
    public void safeData(String name) {
    	MessageRepositoryPort out = new PostgresStorage();
    	out.storeMessage(name);
    }
}
