package polymorphisn;

class Hero{
	String name;
	int hp;
	public void kill(Mortal m) {
		m.die();
	}
	
}

class ADHero extends Hero implements Mortal{
	public ADHero(String name) {
		this.name=name;
	}
	public void die() {
		System.out.println(name+" is die!");
	}
}

class APHero extends Hero implements Mortal{
	public APHero(String name) {
		this.name=name;
	}
	public void die() {
		System.out.println(name+" is die!");
	}
}

class ADAPHero extends Hero implements Mortal{
	public ADAPHero(String name) {
		this.name=name;
	}
	public void die() {
		System.out.println(name+" is die!");
	}
}

public class TestPolymorphisn {
	public static void main(String[] args) {
		Hero caocao =new Hero();
		caocao.name="曹操";
		ADHero jialuo=new ADHero("伽罗");
		APHero zhenji=new APHero("甄姬");
		ADAPHero daqiao=new ADAPHero("大乔");
		caocao.kill(jialuo);
		caocao.kill(zhenji);
		caocao.kill(daqiao);
	}

}
