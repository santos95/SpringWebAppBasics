package com.sortiz.springboot.app.springbootwebapplication.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {

    @GetMapping({"/", "index"})
    public String index(Model model){

        model.addAttribute("title", "Send parameters - GET - URL");
        return "params/index";

    }

    @GetMapping("/string")
    public String params(@RequestParam String name, Model model){

        model.addAttribute("title", "Sending param by GET - URL");
        model.addAttribute("result", "The name is: ".concat(name));

        return "params/ver";

    }

    @GetMapping("/mixparams")
    public String params(@RequestParam String name, @RequestParam int age, Model model){

        model.addAttribute("title", "\"Receive different types of parameters - GET - URL \"");
        model.addAttribute("result", "The name is: " + name + " - The age is: " + age);

        return "params/ver";

    }

    @GetMapping("/paramsrequest")
    public String params(HttpServletRequest request, Model model){

        String name = request.getParameter("name");
        int age;

        try {

            age = Integer.parseInt(request.getParameter("age"));

        } catch (NumberFormatException ex) {

            age = 0;

        }

        model.addAttribute("title", "GET - URL PARAMETERS - HttpServletRequest");
        model.addAttribute("result", "The name is: " + name + " - The age is: " + age);

        return "params/ver";
    }
}
