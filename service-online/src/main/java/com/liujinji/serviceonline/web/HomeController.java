package com.liujinji.serviceonline.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


public class HomeController {
    @GetMapping("/")
    public String home(Model model){
        String text="welcome";
        model.addAttribute("text",text);
        return "home";
    }
}
