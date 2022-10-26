package de.thbingen.movs.microservice.HttpMicroService.service;

import de.thbingen.movs.microservice.HttpMicroService.ports.in.HttpmsPort;
import org.springframework.stereotype.Service;

@Service
public class HttpmsService implements HttpmsPort{
	public void generateMessage(String name) {
		String msg = "Hallo: " + name;
		System.out.println(msg);
	}
}
