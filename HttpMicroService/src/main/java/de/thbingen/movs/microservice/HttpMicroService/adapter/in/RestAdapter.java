package de.thbingen.movs.microservice.HttpMicroService.adapter.in;

import de.thbingen.movs.microservice.HttpMicroService.ports.in.HttpmsPort;
import de.thbingen.movs.microservice.HttpMicroService.service.HttpmsService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAdapter {
	private HttpmsPort httpmsPort = new HttpmsService();
	
	@GetMapping("/hallo")
	public void sayHallo() {
		httpmsPort.generateMessage("hallo");
	}
}
