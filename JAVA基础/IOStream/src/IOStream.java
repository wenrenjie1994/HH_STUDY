import java.io.*;
public class IOStream{
	public static void main(String[] argc){
		/*
		 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		System.out.println("enter 'end' to quit");
		do {
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(str);
		}while(!str.equals("end"));
		*/
		
		OutputStream f = null;
		try {
			f = new FileOutputStream("./testfile.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		OutputStreamWriter writer = null;
		try {
			writer = new OutputStreamWriter(f,"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			writer.append("测试输入：")
			.append("\n")
			.append("java中文输入文件")
			.append("\n")
			.append("English:")
			.append("\n")
			.append("input english")
			.append("\n");
			writer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			f.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InputStream f2 = null;
		try {
			f2 = new FileInputStream("./testfile.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputStreamReader reader = null;
		try {
			reader = new InputStreamReader(f2,"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		StringBuffer sb = new StringBuffer();
		try {
			while(reader.ready()) {
				sb.append((char)reader.read());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sb.toString());
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			f2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}