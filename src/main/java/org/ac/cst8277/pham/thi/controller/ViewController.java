package org.ac.cst8277.pham.thi.controller;

import org.ac.cst8277.pham.thi.config.security.UserManagementService;
import org.ac.cst8277.pham.thi.dto.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class ViewController {

    @Autowired
    private UserManagementService userManagementService;

    @GetMapping("/login")
    public String goLogin(Model model){
        return "login";
    }

    @GetMapping("/register")
    public String goRegister(Model model){
        return "register";
    }

    @GetMapping("/logout")
    public String doLogout(){
        return "redirect: login";
    }

    @GetMapping({"", "/home", "/login/oauth2/code/github"})
    public String goHome(){
        return "home";
    }

    @GetMapping("/401")
    public String error401(){
        return "401";
    }
}
