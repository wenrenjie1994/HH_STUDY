public class MyHero implements Comparable<MyHero> {
    public String name;
    public float hp;
        
    public int damage;
        
    public MyHero(){
           
    }
       
    public MyHero(String name) {
        this.name =name;
   
    }
       
    public MyHero(String name,float hp, int damage) {
        this.name =name;
        this.hp = hp;
        this.damage = damage;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getHp() {
        return hp;
    }
    public void setHp(float hp) {
        this.hp = hp;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public Hero(String name) {
        this.name =name;
    }

    @Override
    public int compareTo(MyHero anotherHero) {
        if(damage<anotherHero.damage)
            return 1; 
        else
            return -1;
    }
   
    @Override
    public String toString() {
        return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
    }
}