package net.leay.demo.aop;

import org.springframework.stereotype.Component;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 5/29/20 4:13 PM
 */
@Component
public class PerformanceImplTwo implements Performance {
  @Override
  public void perform() {
    System.out.println("test");
  }
}
