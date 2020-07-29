package loadAndSaveDate;

import model.JobHunter;

import java.io.*;
import java.util.LinkedList;

public class DateOperator {
    public static void loadData(LinkedList<JobHunter> jobHuntersList) throws IOException {
        BufferedReader br = null;
        //try{
        br = new BufferedReader(new FileReader("E:/01--Java/javaStudy/HH_STUDY/HRS_QR_VERSION/HRS_V2/jobHuntersList.txt"));
        String data = br.readLine();
        while(data != null){
            JobHunter jobHunter = new JobHunter();
            String[] jobhunters = data.split(",");
            jobHunter.setName(jobhunters[0]);
            jobHunter.setGender(jobhunters[1]);
            jobHunter.setMajor(jobhunters[2]);
            jobHunter.setSchool(jobhunters[3]);
            jobHunter.setAge(Integer.parseInt(jobhunters[4]));
            //JobHunter jobHunter = new JobHunter(name, gender, major, school, age);
            jobHuntersList.add(jobHunter);
            data = br.readLine();
        }
        br.close();
        /*}catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                br.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }
*/
    }

    public static  void savaData(LinkedList<JobHunter> jobHuntersList) throws IOException {

        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter("E:/01--Java/javaStudy/HH_STUDY/HRS_QR_VERSION/HRS_V2/jobHuntersList.txt", false));
            int size = jobHuntersList.size();
            for (JobHunter jobHunter : jobHuntersList) {
                bw.write(jobHunter.getName() + "," + jobHunter.getGender() + "," +
                        jobHunter.getMajor() + "," + jobHunter.getSchool() + "," + jobHunter.getAge() + "\r" );
            }
            bw.flush();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bw.close();
        }
    }
}
