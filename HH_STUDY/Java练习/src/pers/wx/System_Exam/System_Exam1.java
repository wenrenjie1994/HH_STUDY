/*王旭 Java项目2020年3月26日*/
package pers.wx.System_Exam;

public class System_Exam1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
			String str;
		   
		   //Java运行时环境版本
		   str=System.getProperty("java.version");
		   System.out.println("运行时环境版本："+str);

		   //Java虚拟机实现的版本
		   str=System.getProperty("java.vm.version");
		   System.out.println("Java虚拟机实现的版本："+str);

		   //Java类的路径
		   str=System.getProperty("java.class.path");
		   System.out.println("Java类的路径："+str);
		   
		   //操作系统版本
		   str=System.getProperty("os.version");
		   System.out.println("操作系统版本："+str);

		   //当前登录操作系统的用户名
		   str=System.getProperty("user.name");
		   System.out.println("当前登录操作系统的用户名："+str);

		   //用户当前路径
		   str=System.getProperty("user.dir");
		   System.out.println("用户当前路径："+str);
		   
		   //用户HOME路径
		   str=System.getProperty("user.home");
		   System.out.println("用户HOME路径："+str);  

	}

}
