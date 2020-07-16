package Server;

public class Parse {
    public static String a ;

    public Parse(String a)
    {
        this.a =a;
    }
    public static String gethead(){
       String[] head = a.split("#");
       return head[0];
    }
    public static String getcontent(){
      String[]  content = a.split("#");
      return  content[1];
    }
}
