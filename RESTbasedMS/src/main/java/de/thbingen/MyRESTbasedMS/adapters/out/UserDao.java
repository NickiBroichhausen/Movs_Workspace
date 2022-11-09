package de.thbingen.MyRESTbasedMS.adapters.out;

import de.thbingen.MyRESTbasedMS.ports.in.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "Messages")
public class UserDao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private Long id;

  @Column(name = "msg")
  private String name;

  private UserDao(User user) {
    this.name = user.getName();
  }


  public static UserDao of(User user) {
    return new UserDao(user);
  }

  public static User toUser(UserDao userDao) {
    return new User(userDao.id, userDao.name);
  }
}
