package loadandsaveData;

import java.io.*;
import java.util.LinkedList;
import model.Resume;

@SuppressWarnings("all")
				public class DataOperate
				{
					public static void loadData(LinkedList<Resume> resumeList)
					{
						BufferedReader br = null;
						try
						{
							br = new BufferedReader(new FileReader("resumelist.txt"));
							String data = br.readLine();
							while(data!=null)
							{
								String[] str = data.split(",");
								String studentName =str[0];
					            int studentID =Integer.parseInt(str[1]);
					            String studentSchool = str[2];
					            int process = Integer.parseInt(str[3]);
                                Resume resume = new Resume(studentName, studentID,studentSchool,process);
                                resumeList.add(resume);
                                data = br.readLine();
				            }
		}
	 catch(IOException exception)
		{
		 	exception.printStackTrace();
		}
	finally
		{
	  	try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	}

	public static void saveData(LinkedList<Resume> resumeList)
	{
		PrintWriter printWriter = null;
		try {
			//printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("booklist.txt",false))));//∏≤∏«–¥»Î
             printWriter = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream("resumelist.txt")
                                    )
                    )
            );
            int resumeCount = resumeList.size();
			for(int i=0;i<resumeCount;i++)
			{
				printWriter.println(resumeList.get(i).studentName +","+ resumeList.get(i).studnetID +","+ resumeList.get(i).studentSchool +","+resumeList.get(i).process);
			}
//            printWriter.println("hh");
//            printWriter.println("jjj");
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
