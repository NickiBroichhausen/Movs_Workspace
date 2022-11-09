package de.thbingen.MyRESTbasedMS.ports.out;

import de.thbingen.MyRESTbasedMS.service.model.User;
import java.util.List;


public interface MessageRepositoryPort {

  Long storeUser(User user);

  List<User> getAllUsers();

  User findUserWithId(Long id);

  List<User> getUsersWithName(String name);

  Boolean deleteUserWithId(Long id);

  Long updateUser(User user);
}
