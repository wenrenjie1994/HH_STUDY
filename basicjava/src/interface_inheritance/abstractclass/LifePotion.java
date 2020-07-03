package interface_inheritance.abstractclass;

public class LifePotion extends Item{
    @Override
    public boolean disposable() {
        System.out.println("血瓶消失");
        return true;
    }
}