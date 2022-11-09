package de.thbingen.MyRESTbasedMS.adapters.out;

import de.thbingen.MyRESTbasedMS.ports.in.User;
import de.thbingen.MyRESTbasedMS.ports.out.MessageRepositoryPort;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

public class PostgresStorage implements MessageRepositoryPort {

  @Autowired
  private PostgresRepository postgresRepository;

  @Override
  public Long storeUser(User user) {
    UserDao userDao = UserDao.of(user);
    userDao = postgresRepository.save(userDao);
    return userDao.getId();
  }

  @Override
  public List<User> getAllUsers() {
    return postgresRepository.findAll().stream().map(userDao -> UserDao.toUser(userDao)).collect(Collectors.toList());
  }

  @Override
  public User findUserWithId(Long id) {
    return UserDao.toUser(postgresRepository.findAllById(List.of(id)).get(0));
  }

  @Override
  public List<User> getUsersWithName(String name) {
    return postgresRepository.findAllByName(name).stream().map(userDao -> UserDao.toUser(userDao)).collect(Collectors.toList());
  }

  @Override
  public Boolean deleteUserWithId(Long id) {
    Boolean isOk = true;
    try {
      postgresRepository.deleteById(id);
    } catch (EmptyResultDataAccessException ex) {
      ex.printStackTrace();
      isOk = false;
    }
    return isOk;
  }

  @Override
  public Long updateUser(User user) {
    postgresRepository.updateUser(user.getId(), user.getName());
    return user.getId();
  }
}
