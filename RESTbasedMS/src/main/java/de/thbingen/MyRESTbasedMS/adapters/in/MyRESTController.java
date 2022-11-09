package de.thbingen.MyRESTbasedMS.adapters.in;

import de.thbingen.MyRESTbasedMS.ports.in.MyRESTbasedMSPort;
import de.thbingen.MyRESTbasedMS.ports.in.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("restdemo")
public class MyRESTController {

  @Autowired
  Environment environment;

  @Autowired
  private MyRESTbasedMSPort myRESTbasedMSPort;

  @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<User> getUsersWithName(@RequestParam(required = false) String name) {
    List<User> users;
    if (name != null) {
      users = myRESTbasedMSPort.getUsersWithName(name);
    } else {
      users = myRESTbasedMSPort.getAllUsers();
    }
    return users;
  }

  @GetMapping(value = "/users/{id}")
  public User getUserWithId(@PathVariable Long id) {
    return myRESTbasedMSPort.findUserWithId(id);
  }

  private String createUrl(Long id) {
    return "http://127.0.0.1:" + environment.getProperty("server.port") + "/restdemo/users/" + id;
  }

  @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
  public String addUser(@RequestBody User user) {
    System.out.println("Adding User: " + user);
    return createUrl(myRESTbasedMSPort.addUser(user));
  }

  @DeleteMapping(value = "/users/{id}")
  public ResponseEntity deleteUserWithId(@PathVariable Long id) {
    HttpStatus httpStatus = myRESTbasedMSPort.deleteUserWithId(id) ? HttpStatus.valueOf(204) : HttpStatus.BAD_REQUEST;
    return new ResponseEntity<>(httpStatus);
  }

  @PatchMapping(value = "/users")
  public ResponseEntity updateUserWithId(@RequestBody User user) {
    Long id = myRESTbasedMSPort.updateUserWithId(user);

    return id != -1 ? ResponseEntity.ok(createUrl(id)) : ResponseEntity.badRequest().build();
  }


  @PutMapping(value = "/users")
  public ResponseEntity replaceUserWithId(@RequestBody User user) {
    Long id = myRESTbasedMSPort.replaceUserWithId(user);

    return id != -1 ? ResponseEntity.ok(createUrl(id)) : ResponseEntity.badRequest().build();
  }

}
