package de.thBingen.U5.RestUebung.adapters.in;

import de.thBingen.U5.RestUebung.ports.in.RestPort;
import de.thBingen.U5.RestUebung.ports.in.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity addUser(@RequestBody User user) {
       boolean success = restPort.postUser(user);
        return success==true?ResponseEntity.ok(user.getId()):ResponseEntity.badRequest().build();
    }
    //id's might be used multiple times

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity deleteUser(@PathVariable int id){
        boolean success = restPort.deleteUser(id);
        return success==true?ResponseEntity.ok(id):ResponseEntity.badRequest().build();
    }


}
