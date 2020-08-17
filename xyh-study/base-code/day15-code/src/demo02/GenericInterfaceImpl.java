package demo02;
/*含有泛型接口的第一种使用方式：定义接口实现类，实现接口，指定接口的泛型
* public interface Iterator<E>
*Sanner类实现了Iterator接口，并指定接口的泛型为String，
* 所以重写的next方法泛型默认就是字符串
* public final calss Scanner implements Iterrator<String>{
*    public String next();
* }
* */
public class GenericInterfaceImpl implements GenericInterface <String>{
    @Override
    public void method(String s){
        System.out.println(s);
    }



}
