package de.thbingen.MyTestMicroService.adapters.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.thbingen.MyTestMicroService.ports.in.HttpmsPort;

@RestController
public class RestAdapter{
	@Autowired
	private HttpmsPort in;
	
	@GetMapping("/hallo")
	public void safeData(String name) {
		in.safeData("tset");
	}
}
