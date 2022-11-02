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
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(user.getId() + "," + user.getName() + "," + user.getSurname());
            bw.newLine();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public User getUser(int id) {
        System.out.println("getting: " + id);
        User user = null;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String next;
            while((next = in.readLine()) != null){
                if(next.startsWith(id+",")){
                    String[] data= next.split(",");
                    user = new User(id, data[1], data[2]);
                }
            }
            in.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(user);
        return user;
    }

    @Override
    public boolean deleteUser(int id) {
        System.out.println("deleting: " + id);
        boolean successful = false;

        try {
            File target_file = new File(this.file);
            File tmp_file = new File("temp.csv");

            BufferedReader reader = new BufferedReader(new FileReader(target_file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tmp_file));

            String currentLine;

            while((currentLine = reader.readLine()) != null) {
                if(currentLine.startsWith(id+","))
                    continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            System.out.println("heir");
            boolean test = target_file.delete();
            System.out.println(test);
            successful = tmp_file.renameTo(target_file);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return successful;
    }
}
