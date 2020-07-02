package net.leay.demo.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 5/29/20 4:00 PM
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AudienceConfig {
  @Bean
  public Audience audience() {
    return new Audience();
  }
}
