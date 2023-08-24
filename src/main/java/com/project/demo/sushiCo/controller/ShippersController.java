package com.project.demo.sushiCo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Shippers")
public class ShippersController {

	 @GetMapping
	    public String getShippersIndexView(Authentication auth, Model model){
	        model.addAttribute("isAuthenticated",auth!=null);
	        return "index";

	 }
}
