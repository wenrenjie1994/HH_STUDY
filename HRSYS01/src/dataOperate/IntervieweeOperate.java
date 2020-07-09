package dataOperate;

import model.Interviewee;

import java.io.*;
import java.util.List;


@SuppressWarnings("all")
public class IntervieweeOperate {
    /**
     * 加载数据
     * @param intervieweeList
     */
    public static void loadData(List<Interviewee> intervieweeList){
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("C:/Users/HP/Desktop/intervieweeList.txt"));
            String data = bufferedReader.readLine();
            while (data!=null){
                String[] str = data.split(",");
                String intervieweeName = str[0];
                String intervieweeSex = str[1];
                Integer intervieweeAge = Integer.parseInt(str[2]);
                String intervieweeSchool = str[3];

                Interviewee interviewee = new Interviewee(intervieweeName,intervieweeSex,intervieweeAge,intervieweeSchool);
                intervieweeList.add(interviewee);

                data = bufferedReader.readLine();//继续读下一行数据
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 保存数据
     * @param intervieweeList
     */
    public static void addData(List<Interviewee> intervieweeList){
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("C:/Users/HP/Desktop/intervieweeList.txt",false)));//append:追加（true）or覆盖（false）

            PrintWriter finalPrintWriter = printWriter;
            intervieweeList.forEach(interviewee -> finalPrintWriter.println(interviewee.getIntervieweeName()+","+interviewee.getIntervieweeSex()+","+interviewee.getIntervieweeAge()+","+interviewee.getIntervieweeSchool()));
            printWriter.flush();
            finalPrintWriter.flush();
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
