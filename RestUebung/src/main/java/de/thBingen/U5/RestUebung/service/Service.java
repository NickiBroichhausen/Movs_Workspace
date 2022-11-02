package de.thBingen.U5.RestUebung.service;

import de.thBingen.U5.RestUebung.ports.in.RestPort;
import de.thBingen.U5.RestUebung.ports.in.User;
import de.thBingen.U5.RestUebung.ports.out.CsvPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service implements RestPort {

    @Autowired
    private CsvPort csvPort;

    @Override
    public User getUser(int id) {
        return csvPort.getUser(id);
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public boolean postUser(User user) {
        return csvPort.addUser(user);
    }

    @Override
    public boolean patchUser(User user, int id) {
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        return csvPort.deleteUser(id);
    }
}
