package dataoperation;

import model.Resume;

import java.io.*;
import java.util.LinkedList;

public class DataOperation {
    
    public static void loadData(LinkedList<Resume> resumeList, String dataPath) {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(dataPath));
            String data = br.readLine();

            while (data != null) {
                String[] strings = data.split("，");
                String name = strings[0];
                String id = strings[1];
                String school = strings[2];

                Resume r = new Resume(name, id, school);
                resumeList.add(r);
                data = br.readLine();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveData(LinkedList<Resume> resumeList, String dataPath)
    {
        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(dataPath,false)));
            int resumeCount = resumeList.size();
            for (int i=0; i<resumeCount; i++)
            {
                printWriter.println(resumeList.get(i).getName()+"，" +
                        resumeList.get(i).getId()+"，"+resumeList.get(i).getSchool());
            }
            printWriter.flush();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            printWriter.close();
        }
    }
}
