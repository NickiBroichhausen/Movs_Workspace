package de.thbingen.MyTestMicroService.adapters.in;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.thbingen.MyTestMicroService.ports.in.HttpmsPort;
import de.thbingen.MyTestMicroService.service.Service;

@RestController
public class RestAdapter{
	private HttpmsPort in = new Service();
	
	@GetMapping("/hallo")
	public void safeData(String name) {
		in.safeData("tset");
	}
}
