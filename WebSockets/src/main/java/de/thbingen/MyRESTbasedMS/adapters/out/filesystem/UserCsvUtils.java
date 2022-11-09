package de.thbingen.MyRESTbasedMS.adapters.out.filesystem;

import de.thbingen.MyRESTbasedMS.service.model.User;

public class UserCsvUtils {

  static public String toCsv(User user) {
    return user.getId() + "," + user.getName();
  }

  static public User fromCsv(String csvLine) {
    var split = csvLine.split(",");
    return new User(Long.valueOf(split[0]), split[1]);
  }
}
