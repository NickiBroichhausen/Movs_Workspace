package de.thbingen.MyRESTbasedMS.service;

import de.thbingen.MyRESTbasedMS.ports.in.MyRESTbasedMSPort;
import de.thbingen.MyRESTbasedMS.ports.in.User;
import de.thbingen.MyRESTbasedMS.ports.out.MessageRepositoryPort;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyRESTbasedMS implements MyRESTbasedMSPort {

  @Autowired
  private MessageRepositoryPort messageRepositoryPort;


  @Override
  public Long addUser(User user) {
    return messageRepositoryPort.storeUser(user);
  }

  @Override
  public List<User> getAllUsers() {
    return messageRepositoryPort.getAllUsers();
  }

  @Override
  public User findUserWithId(Long id) {
    return messageRepositoryPort.findUserWithId(id);
  }

  @Override
  public List<User> getUsersWithName(String name) {
    return messageRepositoryPort.getUsersWithName(name);
  }

  @Override
  public Boolean deleteUserWithId(Long id) {
    return messageRepositoryPort.deleteUserWithId(id);
  }

  @Override
  public Long updateUserWithId(User user) {
    if (findUserWithId(user.getId()) != null) {
      return messageRepositoryPort.updateUser(user);
    }
    return -1L;
  }

  @Override
  public Long replaceUserWithId(User user) {
    Long id = -1L;
    if (deleteUserWithId(user.getId())) {
      User newUser = new User();
      newUser.setName(user.getName());
      id = addUser(newUser);
    }
    return id;
  }
}
