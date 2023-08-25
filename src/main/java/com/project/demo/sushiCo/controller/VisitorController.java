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
import com.project.demo.sushiCo.domain.dto.SelectDishesFormDto;
import com.project.demo.sushiCo.domain.dto.SelectWhichYouPreferFormDto;
import com.project.demo.sushiCo.service.AddInBasketService;
import com.project.demo.sushiCo.service.DishService;
import com.project.demo.sushiCo.service.RestorantService;
import com.project.demo.sushiCo.service.SelectDishesForm;
import com.project.demo.sushiCo.service.SelectWhichYouPreferForm;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/Visitor")
public class VisitorController {
	@Autowired
	private final RestorantService restService;
	private final DishService dishService;
	private final AddInBasketService addInBasketService;

	public VisitorController(RestorantService restService, DishService dishService,
			AddInBasketService addInBasketService) {
		this.restService = restService;
		this.dishService = dishService;
		this.addInBasketService = addInBasketService;
	}

	@GetMapping("/selectRestorant - view")
	public String getRestorantSelectedFormReview(Model model,
			@RequestParam(value = "restorantId", required = false) Integer idSelect, Integer idRestorant ,Integer adminIdWeb)
			throws Exception {
	       model.addAttribute("restorantList",restService.getAllRestorants(adminIdWeb));
		
		if ((idSelect == null) && (idRestorant == null)) {
			var restorantSelected = new SelectWhichYouPreferForm();
			restorantSelected.setIdSelect(idSelect);
			model.addAttribute("restorantPreferenceForm", restorantSelected);
			model.addAttribute("viewTitle","Visitor RestorantPrefered_Selected");
		} else {
			model.addAttribute("restorantPreferenceForm", restService.getRestorantById1(idRestorant));
			model.addAttribute("viewTitle", "Visitor RestorantPrefered_Selected");
		}
		return "tailwindcss/selected - form";
	}

	@PostMapping("/select")
	public String saveSelectedPreference(
			@ModelAttribute("restorantPreferenceForm") @Valid SelectWhichYouPreferFormDto restorantSelected, Integer idRestorant,Integer idSelect,
			BindingResult nResult) throws Exception {
		if (nResult.hasErrors()) {
			return "selected - form ";
		}
		if (((RestorantService) restorantSelected).getRestorantById1(idRestorant) == null) {
			restService.selectRestorant(restorantSelected);
		} else {
			restService.updateRprefered(((RestorantService) restorantSelected).getRestorantById1(idRestorant),
					restorantSelected,idSelect);
		}
		return "redirect:/restorant ";
	}
	
	@GetMapping
	public String getDishesperDishCatReviewList(Model model, Integer idCategoria, Integer adminId) throws Exception {
		model.addAttribute("dish", dishService.getDishesByDishCategory(idCategoria, adminId));
		return " redirect:/dishCategory";
	}

	@GetMapping("/selectDish - form")
	public String getAddInBasketView(Model model, @RequestParam(value = " ", required = false) Integer categoryId,
			Integer adminId, Integer customerId, Integer dId, Integer id) throws Exception {
		model.addAttribute("dish ", dishService.getDishesByDishCategory(categoryId, adminId));
		if (id == null) {
			var selectDish = new SelectDishesForm();
			selectDish.setId(id);
			model.addAttribute("AddInBasket", selectDish);
			model.addAttribute("viewTitle", "Select Dishes");
		} else {
			model.addAttribute("AddInBasket",
					addInBasketService.getDishDCategoriesByCustomerId(dId, categoryId, customerId));
			model.addAttribute("viewTitle", "Update Selected Items");

		}

		return "tailwindcss/selected - form ";
	}

	@PostMapping("/register")
	public String saveSelectedDishesInBasket(
			@ModelAttribute("AddInBasket") @Valid SelectDishesFormDto selectDishesInBasket, BindingResult result,
			Integer categoryId, Integer adminId, Integer customerId, Integer dId, Integer id) throws Exception {
		if (result.hasErrors()) {
			return "redirect:/selectDish - form";
		}
		if (((AddInBasketService) selectDishesInBasket).getDishDCategoriesByCustomerId(dId, categoryId,
				customerId) == null) {
			addInBasketService.create(selectDishesInBasket);
		} else {
			addInBasketService.update(((AddInBasketService) selectDishesInBasket).getDishDCategoriesByCustomerId(dId,
					categoryId, customerId), selectDishesInBasket, dId, categoryId, customerId);
			addInBasketService.delete(((AddInBasketService) selectDishesInBasket).getDishDCategoriesByCustomerId(dId,
					categoryId, customerId), selectDishesInBasket, dId);
		}
		return "redirect:/user/register-view ";
	}

}