import java.util.*;
public class DataStructure {
    public static void main(String[] args)
    {
        /*
        Vector vec = new Vector();
        System.out.println("vec isEmpty :" + vec.isEmpty());
        System.out.println("Initial size :" + vec.size());
        System.out.println("initial capacity :" + vec.capacity()+"\n");

        vec.addElement(new Integer(10));
        vec.add("addstring");
        System.out.println("vec isEmpty :" + vec.isEmpty());
        System.out.println("size :" + vec.size());
        System.out.println("capacity :" + vec.capacity());
        System.out.println("vec(0) = " + vec.elementAt(0));
        System.out.println("vec(1) = " + vec.elementAt(1));
        */
        LinkedList al = new LinkedList();
        al.add(new Integer(1));
        al.add(1,new Integer(8));
        al.add(new Float(3.6f));
        al.add("hello java");
        System.out.println("size:" + al.size());
        for(Iterator it = al.iterator(); it.hasNext();)
        {
            System.out.println(it.next());
        }

    }
}
