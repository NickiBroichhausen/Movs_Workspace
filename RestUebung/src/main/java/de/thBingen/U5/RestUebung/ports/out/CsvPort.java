package de.thBingen.U5.RestUebung.ports.out;

import de.thBingen.U5.RestUebung.ports.in.User;
import org.springframework.stereotype.Repository;

@Repository
public interface CsvPort {
    public boolean addUser(User user);
    public User getUser(int id);
    public boolean deleteUser(int id);
}
