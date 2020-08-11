
public class Hero {
	String name;
	float hp;
	float armor;
	int moveSpeed;

	public Hero() {}

	public Hero(String name, float hp) {
		this.name = name;
		this.hp = hp;
	}

	public void revive(Hero h) {
		h = new Hero("teemo", 383);
	}

	public static void main(String[] args) {
		Hero teemo = new Hero("teemo", 383);
		teemo.hp -= 400;
		teemo.revive(teemo);		// 方法内部的参数无法影响外部的参数

		System.out.println(teemo.hp);		// 输出 383-400 = -17

	}