package com.project.demo.sushiCo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.demo.sushiCo.service.UserService;
import com.project.demo.sushiCo.serviceImpl.RegisterUserForm;

import jakarta.validation.Valid;

@Controller
@RequestMapping
public class AuthController {

	private final UserService userService;

    public AuthController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/login")
    public String getLoginForm(){
        return "auth/login-form";
    }

    @GetMapping("/register")
    public String getUserView(Model model){
        model.addAttribute("user",new RegisterUserForm());
        return "auth/register-view";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") @Valid RegisterUserForm user, BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            return "auth/register-view";
        }
        var u = userService.registerUserForm(user);
        return "redirect:/users/details/"+u.getId();
    }
}


