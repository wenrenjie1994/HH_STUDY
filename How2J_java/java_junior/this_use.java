
public class Hero {
	String name;
	float hp;
	float armor;
	int moveSpeed;

	public void showAddress() {		// 打印内存中的虚拟地址
		System.out.println(this);
	}

	public static void main(String[] args) {
		Hero garen = new Hero();
		garan.name = "garen";
		System.out.println(garen);
		garen.showAddress();

		Hero teemo = new Hero();
		teemo.name = "teemo";
		System.out.println(teemo);
		teemo.showAddress();

	}

}


public class Hero {
	String name;
	float hp;
	float armor;
	int moveSpeed;
	public void setName1(String name) {
		name = name;
	}

	public void setName2(String heroname) {
		name = heroname;
	}

	public void setName3(String name) {
		this.name = name;
	}


	//// 通过this调用其他的构造方法 ////
	public Hero(String name) {
		this.name = name;
	}

	public Hero(String name, float hp) {
		this(name);			// this调用其他构造函数（方法）
		this.hp = hp;
	}

	/////////////////////////////////

	public static void main(String[] args) {
		Hero h = new Hero();
		h.setName1("teemo");
		System.out.println(h.name);

		h.setName2("garen");
		System.out.println(h.name);

		h.setName3("houyi");
		System.out.println(h.name);
	}
}


