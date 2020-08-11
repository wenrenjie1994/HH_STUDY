
package charactor;

public interface AD {
	public void physicAttack();
}

public interface PD {
	public void magicAttack();
}

public class ADAPHero extends Hero implements AD, PD {
	@Override
	public void magicAttack() {
		System.out.println("进行魔法攻击")；
	}

	@Override
	public void physicAttack() {
		System.out.println("进行物理攻击")；
	}
}
