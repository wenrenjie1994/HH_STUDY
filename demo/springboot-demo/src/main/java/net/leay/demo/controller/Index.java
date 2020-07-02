package net.leay.demo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hqweay
 * @description: TODO
 * Created on 5/28/20 11:36 PM
 */

@RestController
@RequestMapping("/test")
public class Index {

  @GetMapping("/001")
  @ResponseStatus(HttpStatus.OK)
  public String test() {
    return "test";
  }
}
