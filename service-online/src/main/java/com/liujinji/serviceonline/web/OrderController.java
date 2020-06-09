package com.liujinji.serviceonline.web;

import com.liujinji.serviceonline.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {
    @GetMapping()
    public String oderForm(Model model){
        model.addAttribute("order",new Order());
        return "orderForm";
    }
    @PostMapping
    public String orderProcess(@Valid Order orderInfo, Errors errors){
        if (errors.hasErrors()){
            log.warn("数据格式错误");
            return "/orderForm";
        }
        log.info(orderInfo.toString());
        return "/orderForm";
    }
}
