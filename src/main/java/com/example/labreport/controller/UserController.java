package com.example.labreport.controller;

import com.example.labreport.business.services.ReportService;
import com.example.labreport.business.services.UserService;
import com.example.labreport.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

public class UserController {


    private ReportService reportService;
    private UserService userService;


    @Autowired
    public UserController(ReportService reportService, UserService userService) {
        this.reportService = reportService;
        this.userService = userService;
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/users")
    public String users(Model model) {

        List<User> users = userService.getAllUsers();

        model.addAttribute("users", users);

        return "users";
    }


    @GetMapping("/users/addForm")
    public String addUser(Model model) {

        User user = new User();
        model.addAttribute("user", user);
        return "addUserForm";
    }

    @PostMapping("/users/addUser")
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "addUserForm";
        }
        userService.addUser(user);

        return "redirect:/users";
    }




    @GetMapping("/users/edit")
    public String editUser(Model model) {

        User user = new User();
        model.addAttribute("user", user);
        return "editUserForm";
    }





    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

}
