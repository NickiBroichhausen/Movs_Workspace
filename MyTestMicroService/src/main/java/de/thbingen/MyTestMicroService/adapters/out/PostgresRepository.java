package de.thbingen.MyTestMicroService.adapters.out;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresRepository extends JpaRepository<DBMessageDao, Long> {

}
