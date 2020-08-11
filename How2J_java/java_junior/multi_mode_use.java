

public interface Mortal {
	public void die();
}

public class ADHero implements Mortal {
	@Override
	public void die() {
		System.out.println("ADHero")；
	}
}

public class APHero implements Mortal {
	@Override
	public void die() {
		System.out.println("APHero")；
	}
}

public class ADAPHero implements Mortal {
	@Override
	public void die() {
		System.out.println("ADAPHero")；
	}
}

public class Hero {
	public String name;
	protected float hp;

	public void kill(Mortal m) {
		m.die();
	}

	public static void main(String[] args) {
		Hero h = new Hero();
		h.name = "garen";

		Mortal m1 = new ADHero();
		Mortal m2 = new APHero();
		Mortal m3 = new ADAPHero();

		h.kill(m1);
		h.kill(m2);
		h.kill(m3);
	}
}