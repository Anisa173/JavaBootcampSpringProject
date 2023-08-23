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

	@GetMapping
	public String getUserReviewList(Model model) throws Exception {
		model.addAttribute(" user ", userService.getAllUser());
		return " tailwindcss/user - list ";
	}

	@GetMapping
	public String getShipperReviewList(Model model, Integer id) throws Exception {
		model.addAttribute(" shippers ", userService.getAllShippersByAdminId(id));
		return " tailwindcss/user - list ";
	}

	@GetMapping("/api/user/register")
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
		return "tailwindcss/register-view";
	}

	@GetMapping("/api/user/login")
	public String getUserLoginView(Model model,@RequestParam(value = "usersId", required = false) Integer registrationId, Integer userId)
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

	@PostMapping("/register")
	public String saveUserRegistrationForm(Integer userId, Integer idRestorant, Integer registrationId,
			@ModelAttribute("registration-UserForm") @Valid RegisterUserFormDto registerUserForm, BindingResult bResult)
			throws Exception {
		if (bResult.hasErrors()) {
			return "registration-UserForm ";
		}
		if (((UserService) registerUserForm).getUserById(userId, idRestorant, registrationId) == null) {
			userService.registerNewUserAccount(registerUserForm, idRestorant, userId,registrationId);
		} else {
			try {
				userService.update(((UserService) registerUserForm).getUserById(userId, idRestorant, registrationId),
						registerUserForm);

			} catch (Exception e) {
				System.out.println("An error ocurred" + "==> " + e.getMessage());
			}
		}
		return "redirect:/api/user";
	}

	@PostMapping("/login")
	public String saveloginForm(
			@ModelAttribute("login-form") @Valid LoginDto loginForm, BindingResult nResult, Integer userId1,
			Integer registrationId1) throws Exception {
		if (nResult.hasErrors()) {
			return "login-form";
		}
		if (((UserService) loginForm).getUserLogInById(userId1, registrationId1) != null) {
			userService.updateLoginData(((UserService) loginForm).getUserLogInById(userId1, registrationId1),
					loginForm);
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
