package operate;
import java.io.*;
import java.util.LinkedList;

/**
 * 进行字符流读取操作
 * @author 张馨悦
 *
 */
public class DataOperate {

	//读取txt中数据操作
    public static void loadData(LinkedList<Resume> resumes) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("E:/HR.txt"));
            String s = br.readLine();
            while (s != null) {
                String[] ss = s.split(",");
                String name = ss[0];
                String id = ss[1];
                String education = ss[2];
                String telephone = ss[3];
                int process = Integer.parseInt(ss[4]);
                Resume resume = new Resume(name, id, education, telephone, process);
                resumes.add(resume);
                s = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //数据写入txt操作
    public static void saveData(LinkedList<Resume> resumes) {
        try {
        	PrintWriter pw = new PrintWriter(new FileWriter("E:/HR.txt"));
        	for (Resume resume:resumes) {
                pw.println(resume.getName() + ","
                			+ resume.getId() + ","
                			+ resume.getEducation() + ","
                			+ resume.getTelephone() + ","
                			+ resume.getProcess());
            }
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}