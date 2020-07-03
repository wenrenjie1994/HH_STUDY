package interface_inheritance.abstractclass;

public class Weapon extends Item{
    @Override
    public boolean disposable() {
        System.out.println("武器存在");
        return false;
    }
}
