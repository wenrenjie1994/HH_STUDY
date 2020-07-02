package net.leay.demo.aop;

import org.springframework.stereotype.Component;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 5/29/20 4:00 PM
 */
@Component
public class PerformanceImpl implements Performance {
  @Override
  public void perform() {
    System.out.println("the perform is good");
  }
}
