package de.thbingen.MyTestMicroService.adapters.out;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "Messages")
public class DBMessageDao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "msg")
  private String msg;

  private DBMessageDao(String msg) {
    this.msg = msg;
  }

  public static DBMessageDao of(String msg) {
    return new DBMessageDao(msg);
  }
}
