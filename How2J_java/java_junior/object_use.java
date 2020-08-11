
public class Hero {
    public String name;
    protected float hp;

    public String toString() {
        return name;
    }

    public boolean equals(Object o) {
        if(o instanceof Hero) {
            Hero h = (Hero) o;
            return this.hp == h.hp;
        }
        return false;
    }

    public static void main(String[] args) {
    	Hero h = new Hero();
    	h.name = "garen";
    	System.out.println(h.toString());
    	System.out.println(h);		// 直接打印对象就是打印该对象的 toString() 返回值

        Hero h1 = new Hero();
        h1.hp = 300;
        Hero h2 = new Hero();
        h2.hp = 400;
        Hero h3 = new Hero();
        h3.hp = 300;

        System.out.println(h1.equals(h2));	// false 
        System.out.println(h1.equals(h3));	// true 

        System.out.println(h1 == h2);	// false 
        System.out.println(h1 == h3);	// false
    }
}