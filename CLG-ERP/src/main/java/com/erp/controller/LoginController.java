package com.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.erp.model.Login;
import com.erp.model.User;
import com.erp.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@GetMapping("/register")
	public String showRegisterForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("login", new Login());
		return "login";
	}
	
	@PostMapping("/saveUser")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        try {
        	loginService.saveUser(user);
            model.addAttribute("message", "User registered successfully!");
        } catch (Exception e) {
            model.addAttribute("error", "Error registering user: " + e.getMessage());
        }
        return "redirect:/login";
    }

}
