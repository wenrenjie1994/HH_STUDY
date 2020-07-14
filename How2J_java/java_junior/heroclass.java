
public class Hero {
	String name;
	float hp;
	float armor;
	int movespeed;

	void keng() {
		System.out.println("keng teammate");
	}

	float getarmor() {
		return armor;
	}

	void addSpeed(int speed) {
		moveSpeed += speed;
	}

	public static void main(String[] args) {
		Hero garen = new Hero();
		garen.name = "盖伦"；
		garen.hp = 616.28f;
		garen.armor = 27.537f;
		garen.moveSpeed = 350;

		Hero teemo = new Hero();
		teemo.name = "提莫";
		teemo.hp = 383f;
		teemo.armor = 14f;
		teemo.moveSpeed = 330;
	}
}