package de.thBingen.U5.RestUebung.adapters.out;

import de.thBingen.U5.RestUebung.ports.in.User;
import de.thBingen.U5.RestUebung.ports.out.CsvPort;
import org.springframework.stereotype.Repository;

import java.io.*;

@Repository
public class CsvStorage implements CsvPort {

    private final String file = "data.csv";
    @Override
    public boolean addUser(User user) {
        System.out.println(user);
        try {
//            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//            in.readLine();
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(user.toString());
            bw.newLine();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public User getUser(int id) {
        System.out.println("getting: " + id);
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        System.out.println("deleting: " + id);
        return true;
    }
}
