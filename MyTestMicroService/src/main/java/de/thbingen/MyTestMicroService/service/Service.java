package de.thbingen.MyTestMicroService.service;

import org.springframework.beans.factory.annotation.Autowired;

import de.thbingen.MyTestMicroService.ports.in.HttpmsPort;
import de.thbingen.MyTestMicroService.ports.out.MessageRepositoryPort;

@org.springframework.stereotype.Service
public class Service implements HttpmsPort{
	@Autowired
	private MessageRepositoryPort out;
	
    public void safeData(String name) {

    	out.storeMessage(name);
    }
}
