package highLevel;

import java.util.ArrayList;
/*
泛型只能是引用类型，不能是基本数据类型（int、double等）
如果希望向集合中ArrayList中存储基本数据类型，则必须使用基本数据类型对应的包装类

基本类型             包装类（引用类型，包装类都位于java.lang包下）
byte      Byte
short     Short
int       Integer [特殊]
long      Long
float     Float
double    Double
char      Character [特殊]
boolean   Boolean

从jdk1.5+开始，支持自动装箱、自动拆箱
自动装箱：基本数据类型自动转换成其对应的包装类
自动拆箱：包装类自动拆成对应的基本数据类型
 */
public class API03ArrayListBasic {

	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<>();
		//错误写法！泛型只能是引用类型，不能是基本类型
		//ArrayList<int> list2 = new ArrayList<>();
		
		//向集合中添加int数据
		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(24);
		list3.add(8);
		System.out.println(list3);//[24, 8]
		
		//从集合中取出int数据
		int num = list3.get(1);
		System.out.println("索引值为1的元素是：" + num);
		
	}

}
