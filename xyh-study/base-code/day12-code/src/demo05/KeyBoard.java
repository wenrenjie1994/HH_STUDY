package demo05;

public class KeyBoard implements USB {
    @Override
    public void open() {
        System.out.println("´ò¿ª¼üÅÌ");
    }

    @Override
    public void close() {
        System.out.println("¹Ø±Õ¼üÅÌ");
    }

    public void type(){
        System.out.println("ÇÃ´ò¼üÅÌ");
    }
}
