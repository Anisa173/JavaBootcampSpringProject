package com.project.demo.sushiCo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.demo.sushiCo.domain.dto.LoginDto;
import com.project.demo.sushiCo.domain.dto.RegisterUserFormDto;
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
	public String getLoginForm() {
		return "auth/login-form";
	}

	@GetMapping("/register")
	public String getUserView(Model model) {
		model.addAttribute("user", new RegisterUserForm());
		return "auth/register-view";
	}

	@PostMapping("/register")
	public String saveUserRegistrationForm(@ModelAttribute("user") @Valid RegisterUserFormDto registerUserForm,
			BindingResult bindingResult, Integer userId, Integer registrationId, Integer idRestorant) throws Exception {
		if (bindingResult.hasErrors()) {
			return "auth/register-view";
		}
		var u = ((UserService) userService).registerNewUserAccount(registerUserForm, userId, registrationId,
				idRestorant);
		return "redirect:/users/details/" + (((UserService) u).getUserById(userId, registrationId, idRestorant));
	}

	@PutMapping("/register")
	public String modifyRegistrationForm(@ModelAttribute("user") @Valid RegisterUserFormDto registerUserForm,
			@Valid RegisterUserFormDto registerUserForm1, BindingResult bindingResult, Integer userId,
			Integer registrationId, Integer idRestorant) throws Exception {
		if (bindingResult.hasErrors()) {
			return "auth/register-view";
		}

		var m = userService.update(registerUserForm, registerUserForm1);
		return "redirect:/users/details/" + (((UserService) m).getUserById(userId, registrationId, idRestorant));

	}

	@PostMapping("/login")
	public String saveloginForm(@ModelAttribute("user") @Valid LoginDto loginForm, @Valid LoginDto loginForm1,
			BindingResult nResult, Integer userId1, Integer registrationId1) throws Exception {
		if (nResult.hasErrors()) {
			return "auth/login-form";
		}
		var log = userService.updateLoginData(loginForm, loginForm1);
		return "redirect:/users/details/" + (((UserService) log).getUserLogInById(userId1, registrationId1));
	}
}
