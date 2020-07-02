package java8.lambda;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 6/1/20 10:10 AM
 */
public class RunnableMethodReference {
  public static void main(String[] args) {

    new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("Anonymous");
      }
    }).start();

    new Thread(
            () -> System.out.println("lambda")
    ).start();

    new Thread(ThreadGo::go).start();
  }
}
