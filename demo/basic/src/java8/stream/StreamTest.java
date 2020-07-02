package java8.stream;

import java.util.stream.Stream;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 6/1/20 10:30 AM
 */
public class StreamTest {
  public static void main(String[] args) {
    Stream.of(1, 2, 5, 8, 7).forEach(System.out::print);
  }
}
