package interface_inheritance.myinterface;
import class_object.reference.Hero;

public class Support extends Hero implements Healer{
    @Override
    public void heal(){System.out.println("恢复生命值");}

    public static void main(String[] args){
        Support s = new Support();
        s.heal();
    }
}
