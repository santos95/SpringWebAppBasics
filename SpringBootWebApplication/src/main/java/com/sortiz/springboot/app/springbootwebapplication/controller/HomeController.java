package com.sortiz.springboot.app.springbootwebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//controller para redirigir al index
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "redirect:/app/index";
    }

    @GetMapping("/google")
    public String google(){
        return "redirect:https://www.google.com/";
    }

    @GetMapping("/forward")
    public String useForward(){
        return "forward:/app/index";
    }
}
