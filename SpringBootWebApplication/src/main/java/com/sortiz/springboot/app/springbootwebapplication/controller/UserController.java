package com.sortiz.springboot.app.springbootwebapplication.controller;

import com.sortiz.springboot.app.springbootwebapplication.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping(value = "/profile")
    public String profile(Model model){

        User user = new User();
        user.setFirstName("Santos");
        user.setLastName("Ortiz");
        user.setEmail("sortiz@mail.com");

        model.addAttribute("title", "Profile: ".concat(user.getFirstName()));
        model.addAttribute("user", user);

        return "profile";

    }

    @GetMapping(value = "/listUsers")
    public String listUsers(Model model){

//        List<User> usersList = new ArrayList<>();
//
//        usersList.add(new User("Santos", "Ortiz", "sortiz@gmail.com"));
//        usersList.add(new User("Peter", "Parker", "spiderman@gmail.com"));
//        usersList.add(new User("Peter", "Quil", "starLord@gmail.com"));

//        List<User> usersList = Arrays.asList(
//                new User("Santos", "Ortiz", "sortiz@gmail.com"),
//                new User("Peter", "Parker", "spiderman@gmail.com"),
//                new User("Peter", "Quil", "starLord@gmail.com")
//        );

        model.addAttribute("title", "List of Users");
        //model.addAttribute("usersList", usersList);

        return "userList";

    }

    //with this apply - all the methods of the controller
    //with this we dont have to - model.addAtribute with the userList
    //and we can use the usersList in any of the methods of this controller
    //we use it when we have many data in common
    //or when we have a form controller - with list of options, radioButtons and ...
    @ModelAttribute("usersList")
    public List<User> createUserList(){

        List<User> usersList = Arrays.asList(
                new User("Santos", "Ortiz", "sortiz@gmail.com"),
                new User("Peter", "Parker", "spiderman@gmail.com"),
                new User("Peter", "Quil", "starLord@gmail.com"),
                new User("Scott", "Summers", "cyclops@gmail.com")
                );

        return usersList;

    }

}
