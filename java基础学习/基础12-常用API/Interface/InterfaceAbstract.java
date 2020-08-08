package highLevel.Interface;
/*
接口定义抽象方法的格式：
	public abstract 返回值类型  方法名称(参数列表);
	注意：接口当中的抽象方法，修饰符必须是两个固定的关键字：public abstract 【这两个关键字可以省略不写】
 */
public interface InterfaceAbstract {

	//这是一个抽象方法
	public abstract void methodAbstr();
	
	//这也是抽象方法
	abstract void methodAbstr2();
	
	//这也是抽象方法
	public void methodAbstr3();
	
	//这也是抽象方法
	void methodAbstr4();
}
