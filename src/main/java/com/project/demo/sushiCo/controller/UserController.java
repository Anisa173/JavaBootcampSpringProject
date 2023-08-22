package com.project.demo.sushiCo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.demo.sushiCo.domain.dto.LoginDto;
import com.project.demo.sushiCo.domain.dto.RegisterUserFormDto;
import com.project.demo.sushiCo.domain.dto.UserDto;
import com.project.demo.sushiCo.entity.User;
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

	@GetMapping("/api/user/userRegisterView")
	public String getUserRegistrationView(Model model,
			@RequestParam(value = "usersId", required = false) Integer adminIdWeb, Integer registrationId,
			Integer userId, Integer idRestorant) throws Exception {
		model.addAttribute("restorantList", restService.getAllRestorants(adminIdWeb));
		if ((userId == null) && (registrationId == null)) {
			var registerUserForm = new RegisterUserForm();
			registerUserForm.setRegistrationId(registrationId);
			model.addAttribute("UserForm", registerUserForm);
			model.addAttribute("viewTittle", "User Registration");
		} else {
			model.addAttribute("userForm", userService.getUserById(idRestorant, userId, registrationId));
			model.addAttribute("viewTittle", " UserR_Data Update ");
		}
		return "tailwindcss/user-registration";
	}

	@GetMapping("/api/user/userLoginView")
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
		return "tailwindcss/user-login";
	}

	@PostMapping("/register")
	public String saveUserRegistrationForm(Integer idRestorant, Integer registrationId, Integer userId,
			@ModelAttribute("registration-UserForm")  @Valid RegisterUserFormDto registerUserForm, BindingResult bResult)
			throws Exception {
		if (bResult.hasErrors()) {
			return "registration-UserForm ";
		}
		if (((UserService) registerUserForm).getUserById(idRestorant, registrationId, userId) == null) {
			userService.registerNewUserAccount(registerUserForm, null);
		} else {
			try {
				userService.update(((UserService) registerUserForm).getUserById(userId, registrationId, idRestorant),
						registerUserForm);
			} catch (Exception e) {
				System.out.println("An error ocurred" + "==> " + e.getMessage());
			}
		}
		return "redirect:/api/user";
	}

	@PostMapping("/login")
	public String saveloginForm(Integer registrationId, Integer userId,@ModelAttribute("login - UserForm") @Valid LoginDto loginForm , BindingResult nResult) throws Exception {		
		if (nResult.hasErrors()) {
			return "login - UserForm";
			userService.updateLoginData(((UserService) loginForm).getUserLogInById(userId, registrationId), loginForm);
		}
		return "redirect:/api/user";
	}

	@DeleteMapping
	public String deleteAdmin(@RequestParam(value = "userId", required = true) Integer id) {
		userService.deleteAdmin(id);
		return "redirect:/user ";
	}

	@DeleteMapping
	public String deleteShipper(@RequestParam(value = "userId", required = true) Integer id) {
		userService.deleteShippers(id);
		return "redirect:/user ";
	}
}
