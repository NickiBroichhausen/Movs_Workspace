package de.thbingen.MyRESTbasedMS.ports.in;

import de.thbingen.MyRESTbasedMS.service.model.User;
import java.util.List;

public interface MyRESTbasedMSPort {

  Long addUser(User user);

  List<User> getAllUsers();

  User findUserWithId(Long id);

  List<User> getUsersWithName(String name);

  Boolean deleteUserWithId(Long id);

  Long updateUserWithId(User user);

  Long replaceUserWithId(User user);
}
