package serialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DeserializePerson {
    public static void main(String[] args) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("E:\\IdeaProjects\\basic-code\\day0814-code\\src\\serialize\\list.txt"));
            ArrayList<Person> list = (ArrayList<Person>)ois.readObject();
            for (Person person : list) {
                System.out.println(person.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
