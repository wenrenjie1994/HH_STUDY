package net.leay.demo.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 5/29/20 4:02 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AudienceConfig.class)
public class PerformanceTest {
  @Autowired
  private Performance performanceImpl;

  @Test
  public void perTest() {
    performanceImpl.perform();
  }
}
