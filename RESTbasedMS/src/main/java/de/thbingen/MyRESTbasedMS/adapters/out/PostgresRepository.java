package de.thbingen.MyRESTbasedMS.adapters.out;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PostgresRepository extends JpaRepository<UserDao, Long> {

  List<UserDao> findAllByName(String name);

  @Modifying

  @Query("update UserDao u set u.name = :name where u.id = :id")
  @Transactional
  void updateUser(Long id, String name);
}
