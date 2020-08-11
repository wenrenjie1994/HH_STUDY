package property;

public class Item {
	String name;
	int price;

	public void buy() {
		System.out.println("buy");
	}
	public void effect() {
		System.out.println("物品使用后，可以有效果");
	}

	public static void main(String[] args) {
		Item i1 = new LifePotion();
		Item i2 = new MagicPotion();

		i1.effect();	// 输出：血瓶使用后，可以回血
		i2.effect();	// 输出：魔瓶使用后，可以回魔法
	}
}

public class LifePotion extends Item {
	public void effect() {
		System.out.println("血瓶使用后，可以回血");
	}
}

public class MagicPotion extends Item {
	public class effect() {
		System.out.println("魔瓶使用后，可以回魔法");
	}
}


// 多态使用
package charactor;

import property.Item;
import property.LifePotion;
import property.MagicPotion;

public class Hero {
	public String name;
	protected float hp;

	public void useItem(Item i) {
		i.effect();
	}

	public static void main(String[] args) {
		Hero garen = new Hero();
		garen.name = "garen";

		LifePotion lp = new LifePotion();
		MagicPotion mp = new MagicPotion();

		garen.useItem(lp);
		garen.useItem(mp);
	}
}