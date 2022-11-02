package de.thBingen.U5.RestUebung.adapters.in;

import de.thBingen.U5.RestUebung.ports.in.RestPort;
import de.thBingen.U5.RestUebung.ports.in.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("rest")
public class RestController {
//GET, POST,
//PATCH, PUT, DELETE

    @Autowired
    private RestPort restPort;

    @GetMapping(value="/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable int id){
        return restPort.getUser(id);
    }

    @PostMapping(value="/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody User user) {
       restPort.postUser(user);
    }

    @DeleteMapping(value = "/users/{id}")
    public void deleteUser(@PathVariable int id){
        restPort.deleteUser(id);
    }


}
