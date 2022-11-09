package de.thbingen.MyRESTbasedMS.adapters.out.filesystem;

import de.thbingen.MyRESTbasedMS.ports.out.MessageRepositoryPort;
import de.thbingen.MyRESTbasedMS.service.model.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Repository;

@Repository
public class CsvStorage implements MessageRepositoryPort {

  private Long idCnt = 0L;
  private String fileName = "myFile.txt";
  private File csvFile = new File(fileName);
  private FileInputStream inputStream = new FileInputStream(csvFile);

  public CsvStorage() throws FileNotFoundException {
  }

  private Stream fileToStream(String data) {
    return List.of(data.split("\n")).stream().map(csvLine -> UserCsvUtils.fromCsv(csvLine.trim()));
  }

  public Long storeUser(User user, boolean keepId) {
    user.setId(keepId == false ? idCnt++ : user.getId());
    try (PrintWriter pw = new PrintWriter(new FileOutputStream(csvFile, true))) {
      pw.println(UserCsvUtils.toCsv(user));
    } catch (IOException e) {
    }
    return user.getId();
  }

  @Override
  public Long storeUser(User user) {
    return storeUser(user, false);
  }

  @Override
  public List<User> getAllUsers() {
    List<User> resultList = List.of();
    try {
      String data = FileUtils.readFileToString(csvFile, "UTF-8");
      resultList = (List<User>) fileToStream(data).collect(Collectors.toList());
    } catch (java.io.IOException ex) {

    }
    return resultList;
  }

  @Override
  public User findUserWithId(Long id) {
    User resultUser = null;
    try {
      String data = FileUtils.readFileToString(csvFile, "UTF-8");
      resultUser = (User) fileToStream(data).filter(obj -> ((User) obj).getId() == id).findFirst().get();
    } catch (java.io.IOException ex) {

    }
    return resultUser;
  }

  @Override
  public List<User> getUsersWithName(String name) {
    List<User> resultList = null;
    try {
      String data = FileUtils.readFileToString(csvFile, "UTF-8");
      resultList = (List<User>) fileToStream(data).filter(obj -> ((User) obj).getName().equals(name)).collect(Collectors.toList());
    } catch (java.io.IOException ex) {

    }
    return resultList;
  }

  @Override
  public Boolean deleteUserWithId(Long id) {
    List<User> currentUsers = getAllUsers();

    try (PrintWriter pw = new PrintWriter(new FileOutputStream(csvFile, false))) {
    } catch (IOException e) {
    }

    for (User user : currentUsers) {
      if (user.getId() != id) {
        storeUser(user, true);
      }
    }

    boolean result = true;
    try {
      result = findUserWithId(id) != null;
    } catch (NoSuchElementException ex) {
      return true;
    }
    return result;
  }

  @Override
  public Long updateUser(User user) {
    deleteUserWithId(user.getId());
    storeUser(user);
    return user.getId();
  }
}
