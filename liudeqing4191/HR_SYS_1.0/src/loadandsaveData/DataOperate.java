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
					String resumeName =str[0];
					String resumeId =str[1];
					String resumeSchool =str[2];
					int resumeProcess = Integer.parseInt(str[3]);
					///////
					Resume resume = new Resume(resumeName,resumeId);
					resume.setSchool(resumeSchool);
					resume.setProcess(resumeProcess);
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
			printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("resumelist.txt",false)));//∏≤∏«–¥»Î
			int resumeCount = resumeList.size();
			for(int i=0;i<resumeCount;i++)
			{
				printWriter.println(resumeList.get(i).getName()+","+resumeList.get(i).getId()+","+resumeList.get(i).getSchool()+","+
						resumeList.get(i).getProcess());
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
