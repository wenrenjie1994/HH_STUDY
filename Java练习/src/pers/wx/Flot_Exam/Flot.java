/*王旭 Java项目2020年3月27日*/
package pers.wx.Flot_Exam;

public class Flot {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("单精度浮点型数（float）可以取的最大值为："+Float.MAX_VALUE);
	    System.out.println("单精度浮点型数（float）可以取的最小值为："+Float.MIN_VALUE);
	    System.out.println("单精度浮点型数（float）可以取的NaN值为："+Float.NaN);
	    System.out.println("单精度浮点型数（float）可以取的负无限大为："+Float.NEGATIVE_INFINITY);
	    System.out.println("单精度浮点型数（float）可以取的正无限大为："+Float.POSITIVE_INFINITY);
	    System.out.println("描述单精度浮点型数（float）的类对象为："+Float.TYPE);

	    float x=Float.valueOf("43.645");
	    System.out.println("字符串转换为float型值为："+x);    

	}

}
