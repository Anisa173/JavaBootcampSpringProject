package com.project.demo.sushiCo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {

	public IndexController() {

	}

	@GetMapping
	public String getIndex1(Authentication auth, Model model) {
		model.addAttribute("isAuthenticated", auth != null);
		return "index";
	}
}