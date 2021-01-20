package com.r0b3rth4ns3n.CommunityWiki.controller;

import com.r0b3rth4ns3n.CommunityWiki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login() { return "login"; }

    @RequestMapping("/register")
    public String register(
            @ModelAttribute("username") String username,
            @ModelAttribute("password") String password,
            Model model
    ) {
        if (username.isBlank() || password.isBlank()) {
            model.addAttribute("feedback","please choose a username and password");
            return "register";
        }
        String feedback = userService.register(username,password);
        model.addAttribute("feedback",feedback);
        return "register";
    }

}
