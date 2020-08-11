
public class Item {
	String name;
	int price;
}

public class Armor extends Item {
	int ac;		// 护甲等级

	public static void main(String[] args) {
		Armor ar1 = new Armor();
		Armor ar2 = new Armor();

		ar1.name = "布甲";
		ar1.price = 300;
		ar1.ac = 15;

		ar2.name = "锁子甲";
		ar2.price = 500;
		ar2.ac = 40;

		System.out.println(ar1.name + "-price: " + ar1.price + "-ac: " + ar1.ac);
		System.out.println(ar2.name + "-price: " + ar2.price + "-ac: " + ar2.ac);

	}
}