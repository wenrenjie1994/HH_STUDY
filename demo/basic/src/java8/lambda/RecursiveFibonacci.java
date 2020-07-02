package java8.lambda;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 6/1/20 10:00 AM
 */
// functional/RecursiveFibonacci.java

public class RecursiveFibonacci {
  static IntCall fact;

  public static void main(String[] args) {
    fact = n -> n == 1 ? 1 : n + fact.call(n - 1);
    for (int i = 1; i <= 10; i++) {
      System.out.println(fact.call(i));
    }
  }
}
