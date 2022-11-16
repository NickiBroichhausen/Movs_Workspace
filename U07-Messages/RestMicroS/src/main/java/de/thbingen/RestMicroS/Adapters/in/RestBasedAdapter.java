package de.thbingen.RestMicroS.Adapters.in;

import de.thbingen.RestMicroS.Ports.in.RestBasedPort;
import de.thbingen.RestMicroS.Service.RestMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest")
public class RestBasedAdapter implements RestBasedPort {

    @Autowired
    private RestMS service;

    @Override
    @PostMapping(value = "/message")
    public void recieveHTTP(@RequestBody String message) {
        System.out.println("Rest input: " + message);
        service.recieveHTTP(message);
    }
}
