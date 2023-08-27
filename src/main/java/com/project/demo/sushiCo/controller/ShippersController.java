package com.project.demo.sushiCo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.demo.sushiCo.service.PackageOrderedService;

@Controller
@RequestMapping("/Shippers")
public class ShippersController {

	@GetMapping
	public String getShippersIndexView(Authentication auth, Model model) {
		model.addAttribute("isAuthenticated", auth != null);
		return "index";

	}

	@Autowired
	private final PackageOrderedService pckgService;

	public ShippersController(PackageOrderedService pckgService) {
		this.pckgService = pckgService;
	}

	@GetMapping
	public String getCustomerPackagesList(Model model, Integer userId) throws Exception {
		model.addAttribute("packageOrdered", pckgService.getAllPackageOByCustomerId(userId));
		return " redirect:/packageOrdered ";
	}

	@GetMapping
	public String getAllPackageOs(Model model, Integer userId) throws Exception {
		model.addAttribute("packageOrdered", pckgService.getAllPackageOByshipperId(userId));
		return "redirect:/packageOrdered ";
	}
}
