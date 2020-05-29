
public class Hero {
    public String name;
    public float hp;
    public int damage;
    public int id;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Hero(){

    }
    public Hero(String string) {
        name =string;
    }

    @Override
    public String toString() {
        return "Hero [name=" + name + "]";
    }
    public boolean isDead() {
        // TODO Auto-generated method stub
        return false;
    }
    public void attackHero(Hero h2) {
        // TODO Auto-generated method stub

    }

}