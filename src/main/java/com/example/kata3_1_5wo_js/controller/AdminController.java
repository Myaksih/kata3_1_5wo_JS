package com.example.kata3_1_5wo_js.controller;

import com.example.kata3_1_5wo_js.model.User;
import com.example.kata3_1_5wo_js.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping({"/", ""})
    public String showAllUsers(Model model, @ModelAttribute("flashMessage") String flashAttribute, Principal principal) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("authUser", user);

        model.addAttribute("newUser", new User());
        return "admin";
    }


    @PutMapping()
    public String saveUser(@ModelAttribute("newUser") User user) {
        userService.save(user);
        return "redirect:/admin";
    }

}
