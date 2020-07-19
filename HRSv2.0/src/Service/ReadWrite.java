package Service;

import Resume.StudentInformation;

import java.io.*;
import java.util.ArrayList;

public class ReadWrite {
    public static void ReadData(ArrayList<StudentInformation> stinfo) {
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\java\\MyRepository\\HRSv2.0\\ResumeData.txt"));){
            while((line = br.readLine())!=null){
                String[] arr = line.split(",");
                int id = Integer.parseInt(arr[0]);
                String name = arr[1];
                String school = arr[2];
                String email = arr[3];
                StudentInformation sresume = new StudentInformation(id,name,school,email);
                stinfo.add(sresume);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void WriteData(ArrayList<StudentInformation> stinfo){
        String line;
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\java\\MyRepository\\HRSv2.0\\ResumeData.txt"));){
            for(StudentInformation st:stinfo){
                line = st.getId() + ", " + st.getName() +", " + st.getSchool() +  ", " + st.getEmail();
                bw.write(line);
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
