package de.thbingen.RestMicroS.Service;

import de.thbingen.RestMicroS.Ports.out.MessagePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestMS {

    @Autowired
    private MessagePort out;

    public void recieveHTTP(String message){
        out.notify(message);
    }
}
