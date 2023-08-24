package com.project.demo.sushiCo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.demo.sushiCo.domain.dto.RestorantDto;
import com.project.demo.sushiCo.domain.dto.SelectWhichYouPreferFormDto;
import com.project.demo.sushiCo.service.RestorantService;
import com.project.demo.sushiCo.service.SelectWhichYouPreferForm;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/Visitor")
public class VisistorController {
	@Autowired
	private final RestorantService restService;

	public VisistorController(RestorantService restService) {
		this.restService = restService;
	}

@GetMapping("/selectRestorant - view")
public String getRestorantSelectedFormReview(Model model,@RequestParam(value = "restorantId" , required = false) Integer idSelect,Integer idRestorant) throws Exception {
if((idSelect == null) && (idRestorant == null)) {
var restorantSelected = new SelectWhichYouPreferForm();	
restorantSelected.setIdSelect(idSelect) ;
model.addAttribute("restorantPreferenceForm" ,restorantSelected );
model.addAttribute("viewTitle","Visitor Selected_RestorantForm");
}
else {
	model.addAttribute("restorantPreferenceForm", restService.getRestorantById1(idRestorant));
model.addAttribute("viewTitle" ,"Visitor Selected_RestorantForm" );
}
return "tailwindcss/selected - form";
}

@PostMapping("/select")
public String saveSelectedPreference(@ModelAttribute("restorantPreferenceForm") @Valid  RestorantDto restorantSelected,Integer idRestorant,BindingResult nResult) throws Exception{
if(nResult.hasErrors()) {
return "selected - form ";
}
if(((RestorantService) restorantSelected).getRestorantById1(idRestorant) == null) {
restService.create(restorantSelected);
}
else {
	restService.createSelectRestorant(((RestorantService) restorantSelected).getRestorantById1(idRestorant),restorantSelected);
}
return "redirect:/restorant ";
}





}