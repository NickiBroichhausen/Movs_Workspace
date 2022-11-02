package de.thBingen.U5.RestUebung.ports.in;

import java.util.List;

public interface RestPort {
    //GET, POST,
    //PATCH, PUT, DELETE

    User getUser(int id);

    List<User> getAllUser();

    boolean postUser(User user);

    boolean patchUser(User user, int id);

    boolean deleteUser(int id);
}
