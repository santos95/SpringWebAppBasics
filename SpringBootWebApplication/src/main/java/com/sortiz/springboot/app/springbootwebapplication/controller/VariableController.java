package com.sortiz.springboot.app.springbootwebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/variable")
public class VariableController {

    @GetMapping({"/", "index"})
    public String index(Model model){

        model.addAttribute("title", "Send parameters by route = @PathVariable");
        return "variable/index";

    }

    @GetMapping(value = "/string/{name}")
    public String variable(@PathVariable String name, Model model) {

        model.addAttribute("title", "Send parameters by route = @PathVariable");
        model.addAttribute("result", "The name is: " + name);

        return "/variable/ver";

    }

    @GetMapping("/string/{name}/{age}")
    public String variable(@PathVariable String name, @PathVariable Integer age, Model model) {

        model.addAttribute("title", "Send parameters by route = @PathVariable");
        model.addAttribute("result", "The name is: " + name + " Age: " + age);

        return "/variable/ver";


    }


}
