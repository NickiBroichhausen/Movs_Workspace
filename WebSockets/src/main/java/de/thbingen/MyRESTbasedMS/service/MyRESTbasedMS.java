package de.thbingen.MyRESTbasedMS.service;

import de.thbingen.MyRESTbasedMS.ports.in.MyRESTbasedMSPort;
import de.thbingen.MyRESTbasedMS.ports.out.MessageRepositoryPort;
import de.thbingen.MyRESTbasedMS.ports.out.Operation;
import de.thbingen.MyRESTbasedMS.ports.out.UpdatesNotificationPort;
import de.thbingen.MyRESTbasedMS.service.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyRESTbasedMS implements MyRESTbasedMSPort {

  @Autowired
  private UpdatesNotificationPort updateNotification;

  @Autowired
  private MessageRepositoryPort messageRepositoryPort;

  @Override
  public Long addUser(User user) {
    Long id = messageRepositoryPort.storeUser(user);
    if(id != -1)
      updateNotification.notify(user, Operation.CREATED);
    return id;
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
    boolean success = messageRepositoryPort.deleteUserWithId(id);
    if(success)
      updateNotification.notify(findUserWithId(id), Operation.DELETED);
    return success;
  }

  @Override
  public Long updateUserWithId(User user) {
    if (findUserWithId(user.getId()) != null) {
      long success = messageRepositoryPort.updateUser(user);
      if(success != -1L)
        updateNotification.notify(user, Operation.UPDATED);
      return success;
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
