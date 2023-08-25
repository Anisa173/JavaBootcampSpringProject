package com.project.demo.sushiCo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.demo.sushiCo.domain.dto.DishCategoryDto;
import com.project.demo.sushiCo.domain.dto.RegisterDishFormDto;
import com.project.demo.sushiCo.service.DishCategoryService;
import com.project.demo.sushiCo.service.DishService;
import com.project.demo.sushiCo.service.RegisterCategoryDishForm;
import com.project.demo.sushiCo.serviceImpl.RegisterDishForm;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/Admin")
public class AdminController {

	@Autowired
	private final DishCategoryService dcService;
	private final DishService dService;

	public AdminController(DishCategoryService dcService, DishService dService) {
		this.dcService = dcService;
		this.dService = dService;
	}

	@GetMapping
	public String getAdminIndexView(Authentication auth, Model model) {
		model.addAttribute("isAuthenticated", auth != null);
		return "index";
	}

	@GetMapping("/register-view")
	public String getDcategRegistrReview(Model model, @RequestParam(value = "dcId", required = false) Integer id,
			Integer adminId) throws Exception {
		if (id == null) {
			model.addAttribute("dish_categoryForm", new RegisterCategoryDishForm());
			model.addAttribute("viewTitle", "Category Registration");
		} else {
			model.addAttribute("dish_categoryForm", dcService.getDishCategoryById(id, adminId));
			model.addAttribute("viewTitle", "Category Update");
		}
		return "tailwindcss/registration - form ";
	}

	@PostMapping("/api/register")
	public String registerCategory(@ModelAttribute("dish_categoryForm") @Valid DishCategoryDto dcDto,
			BindingResult result, Integer id, Integer adminId) throws Exception {
		if (result.hasErrors()) {
			return "redirect:/registration - form";
		}
		if (((DishCategoryService) dcDto).getDishCategoryById(id, adminId) == null) {
			dcService.create(dcDto);
		} else {
			dcService.update(((DishCategoryService) dcDto).getDishCategoryById(id, adminId), dcDto, id, adminId);
		}
		return "redirect:/DishCategory ";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam(value = " ", required = true) Integer id, Integer adminId) throws Exception {
		dcService.delete(id, adminId);

		return " redirect:/dishcategory";
	}

	@GetMapping
	public String getDishCategoryReviewList(Model model, Integer adminId) throws Exception {
		model.addAttribute("DishCategory", dcService.getDishCategorybyRestorant(adminId));
		return "redirect:/dishcategory ";
	}

	@GetMapping("/register-view")
	public String getDishRegistrationReview(Model model,
			@RequestParam(value = "dishId", required = false) Integer idRegistration, Integer dId, Integer categoryId,
			Integer adminId) throws Exception {
		model.addAttribute("DishCategoryList", dService.getDishByDishCategory(dId, categoryId, adminId));
		if (dId == null) {
			var regDish = new RegisterDishForm();
			regDish.setIdRegistration(idRegistration);
			model.addAttribute("dishForm", regDish);
			model.addAttribute("viewTitle", "Dish Regisration");
		} else {
			model.addAttribute("dishForm", ((DishService) dService).getDishByDishCategory(dId, categoryId, adminId));
			model.addAttribute("viewTitle", " Dish Modified");
		}

		return "tailwindcss/registration - form ";
	}

	public String saveRegistrationDish(@ModelAttribute("dishForm") @Valid RegisterDishFormDto regDishForm,
			BindingResult bResult, Integer dId, Integer categoryId, Integer adminId) throws Exception {
		if (bResult.hasErrors()) {
			return "redirect:/registration - form";
		}

		if (((DishService) regDishForm).getDishByDishCategory(dId, categoryId, adminId) == null) {
			dService.create(regDishForm);
		} else {
			dService.update(((DishService) regDishForm).getDishByDishCategory(dId, categoryId, adminId), regDishForm,
					adminId, categoryId, dId);
		}
		return "redirect:/Dish ";
	}
}