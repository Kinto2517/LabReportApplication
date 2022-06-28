package com.example.labreport.controller;

import com.example.labreport.business.services.ReportService;
import com.example.labreport.business.services.UserService;
import com.example.labreport.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {


    private ReportService reportService;
    private UserService userService;


    @Autowired
    public UserController(ReportService reportService, UserService userService) {
        this.reportService = reportService;
        this.userService = userService;
    }



    @GetMapping("/main")
    public String users(Model model) {

        List<User> users = userService.getAllUsers();

        model.addAttribute("users", users);

        return "users";
    }


    @GetMapping("/addForm")
    public String addUser(Model model) {

        User user = new User();
        model.addAttribute("user", user);
        return "addUserForm";
    }

    @PostMapping("/addUser")
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "addUserForm";
        }
        userService.addUser(user);

        return "redirect:/users/main";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam Long id ) {

        User user = userService.getUserById(id);

        if (user != null) {
            userService.deleteUser(user.getId());
        }

        return "redirect:/users/main";

    }




}
