package highLevel.Extends;

public class NewPhone extends Phone{
	
	public NewPhone() {
		super(24); //子类构造方法可通过super关键字调用父类重载的构造方法
		System.out.println("子类构造方法！");
	}
	
	//子类重写父类方法
	public void show() {
		//把父类的show方法拿过来重复利用
		super.show();
		//子类自己再添加新的内容
		System.out.println("显示头像!");
		System.out.println("显示姓名!");
	}
}
