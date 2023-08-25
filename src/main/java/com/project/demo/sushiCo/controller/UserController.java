package com.project.demo.sushiCo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.demo.sushiCo.domain.dto.LoginDto;
import com.project.demo.sushiCo.domain.dto.RegisterUserFormDto;
import com.project.demo.sushiCo.service.RestorantService;
import com.project.demo.sushiCo.service.UserService;
import com.project.demo.sushiCo.serviceImpl.Login;
import com.project.demo.sushiCo.serviceImpl.RegisterUserForm;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/user")
public class UserController {
	private final UserService userService;
	private final RestorantService restService;

	public UserController(UserService userService, RestorantService restService) {
		super();
		this.userService = userService;
		this.restService = restService;
	}

	@GetMapping("/api/user/register - view")
	public String getUserRegistrationView(Model model,
			@RequestParam(value = "usersId", required = false) Integer registrationId, Integer userId,
			Integer idRestorant) throws Exception {
		model.addAttribute("restorantList", restService.getAllRestorants(userId));
		if ((userId == null) && (registrationId == null)) {
			var registerUserForm = new RegisterUserForm();
			registerUserForm.setRegistrationId(registrationId);
			model.addAttribute("userForm", registerUserForm);
			model.addAttribute("viewTittle", "User Registration");
		} else {
			model.addAttribute("userForm", userService.getUserById(idRestorant, userId, registrationId));
			model.addAttribute("viewTittle", " UserR_Data Update ");
		}
		return "tailwindcss/register-view";
	}

	@PostMapping("/register")
	public String saveUserRegistrationForm(Integer userId, Integer idRestorant, Integer registrationId,
			@ModelAttribute("userForm") @Valid RegisterUserFormDto registerUserForm, BindingResult bResult)
			throws Exception {
		if (bResult.hasErrors()) {
			return "register - view ";
		}
		if (((UserService) registerUserForm).getUserById(userId, idRestorant, registrationId) == null) {
			userService.registerNewUserAccount(registerUserForm, idRestorant, userId, registrationId);
		} else {
			try {
				userService.update(userId, idRestorant,
						((UserService) registerUserForm).getUserById(userId, idRestorant, registrationId),
						registerUserForm);

			} catch (Exception e) {
				System.out.println("An error ocurred" + "==> " + e.getMessage());
			}
		}
		return "redirect:/api/User/login";
	}

	@GetMapping("/api/user/login")
	public String getUserLoginView(Model model,
			@RequestParam(value = "usersId", required = false) Integer registrationId, Integer userId)
			throws Exception {
		if ((userId == null) && (registrationId == null)) {
			var loginForm = new Login();
			loginForm.setRegistrationId(registrationId);
			model.addAttribute("LoginForm", loginForm);
			model.addAttribute("viewTittle", " Login ");
		} else {
			model.addAttribute("loginForm", userService.getUserLogInById(userId, registrationId));
			model.addAttribute("viewTittle", " Login_Data Update");

		}
		return "tailwindcss/login-form";
	}

	@PostMapping("/login")
	public String saveloginForm(@ModelAttribute("login-form") @Valid LoginDto loginForm, BindingResult nResult,
			Integer userId1, Integer registrationId1) throws Exception {

		if (nResult.hasErrors()) {
			return "login-form";
		}
		if (((UserService) loginForm).getUserLogInById(userId1, registrationId1) != null) {
			userService.updateLoginData(userId1, ((UserService) loginForm).getUserLogInById(userId1, registrationId1),
					loginForm);
		}
		return "redirect:/api/Customer/SelectWhichYouPreferForm";
	}
}
