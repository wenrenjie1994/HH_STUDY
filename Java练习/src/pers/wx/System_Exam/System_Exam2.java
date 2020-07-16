/*王旭 Java项目2020年3月26日*/
package pers.wx.System_Exam;

public class System_Exam2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//计算在Java虚拟机中执行一亿此空循环所需要的时间
	     long my_begin, my_end;
	     my_begin=System.currentTimeMillis( );  //获取当前时间
	     System.out.println("开始时间："+my_begin);
	     for(long i=0;i<100000000L;i++) ;       //做一亿次空循环
	     my_end=System.currentTimeMillis( );  //获取完成循环的时间
	     System.out.println("结束时间："+my_end);
	     double usedtime=(my_end-my_begin)/1000.0; 
	     System.out.println("运行一亿次空循环的时间是："+usedtime+"秒");

	}

}
