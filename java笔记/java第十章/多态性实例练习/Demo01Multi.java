package basic.method.demo1.day6.day7;

public class Demo01Multi {
    public static void main(String[] args) {
        Fu obj = new Zi();
        obj.method();
        obj.methodFu();

      giveMe(new Zi());
    }
    public static void giveMe(Fu obj){
        if (obj instanceof Zi){
            Zi zi = (Zi) obj;
            zi.methodOnly();
        }
    }
}
