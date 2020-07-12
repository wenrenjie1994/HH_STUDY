package loadandsaveData;
import java.util.LinkedList;
import model.People;
import java.io.*;

public class DataOperate
{
    public static void loadData(LinkedList<People> bookList)
    {
        BufferedReader br=null;
        try{
            br=new BufferedReader(new FileReader("./people.txt"));
            String lines=br.readLine();
            while(lines!=null)
            {
                People people=new People(lines.split(",")[0],
                        lines.split(",")[1],Integer.parseInt(lines.split(",")[2]));
                bookList.add(people);
                lines=br.readLine();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                br.close();
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }

    public static void saveData(LinkedList<People> people)
    {
        PrintWriter pw=null;
        try{
//            pw=new PrintWriter(new OutputStreamWriter(new FileOutputStream("./people.txt",false)));
            pw=new PrintWriter(new FileWriter("./people.txt"));
            for(int i=0;i<people.size();i++)
            {
                pw.println(people.get(i).getName()+","+people.get(i).getID()+","+people.get(i).getSchool());
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                pw.close();
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }
}
