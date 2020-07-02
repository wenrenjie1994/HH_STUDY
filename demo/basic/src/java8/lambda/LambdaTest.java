package java8.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 5/29/20 3:04 PM
 */
public class LambdaTest {
  public static void main(String[] args) {
    int arr[] = {1, 2, 3, 4, 5,};
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    

    list.forEach(System.out::print);
  }
}
