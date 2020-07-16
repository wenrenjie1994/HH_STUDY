package utils;

import bean.Resume;

import java.io.*;
import java.util.LinkedList;

public class DataOperate {
    /**
     * 加载
     *
     * @param resumes
     */
    public static void loadData(LinkedList<Resume> resumes) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\" +
                    "MSI -PC\\Desktop\\HH_STUDY\\Projects\\SelfTaught\\HR_SYS\\src\\resumes.txt"));
            String s = br.readLine();
            while (s != null) {
                String[] strings = s.split(",");
                String name = strings[0];
                String id = strings[1];
                String school = strings[2];
                int process = Integer.parseInt(strings[3]);
                int deleteStatus = Integer.parseInt(strings[4]);
                Resume resume = new Resume(name, id, school);
                resume.setProcess(process);
                resume.setDeleteStatus(deleteStatus);
                resumes.add(resume);
                s = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存
     *
     * @param resumes
     */
    public static void saveData(LinkedList<Resume> resumes) {
        try {
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\MSI -PC" +
                    "\\Desktop\\HH_STUDY\\Projects\\SelfTaught\\HR_SYS\\src\\resumes.txt", false)));
            for (int i = 0; i < resumes.size(); i++) {
                pw.println(resumes.get(i).getName() + "," + resumes.get(i).getId() + "," + resumes.get(i).getSchool() + "," +
                        resumes.get(i).getProcess() + "," + resumes.get(i).getDeleteStatus());
            }
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
