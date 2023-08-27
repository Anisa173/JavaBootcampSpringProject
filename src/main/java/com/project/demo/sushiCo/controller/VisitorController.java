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

import com.project.demo.sushiCo.domain.dto.RegisterBookingFormDto;
import com.project.demo.sushiCo.domain.dto.SelectDishesFormDto;
import com.project.demo.sushiCo.domain.dto.SelectWhichYouPreferFormDto;
import com.project.demo.sushiCo.service.AddInBasketService;
import com.project.demo.sushiCo.service.BookingProcessingService;
import com.project.demo.sushiCo.service.DishService;
import com.project.demo.sushiCo.service.RegisterBookingForm;
import com.project.demo.sushiCo.service.RestorantService;
import com.project.demo.sushiCo.service.RestorantTablesService;
import com.project.demo.sushiCo.service.SelectDishesForm;
import com.project.demo.sushiCo.service.SelectWhichYouPreferForm;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/Visitor")
public class VisitorController {
	@Autowired
	private final RestorantService restService;
	private final RestorantTablesService rTablesService;
	private final DishService dishService;
	private final AddInBasketService addInBasketService;
	private final BookingProcessingService bpService;

	public VisitorController(RestorantService restService, RestorantTablesService rTablesService,
			DishService dishService, AddInBasketService addInBasketService, RestorantTablesService rtbService,
			BookingProcessingService bpService) {
		this.restService = restService;
		this.rTablesService = rTablesService;
		this.dishService = dishService;
		this.addInBasketService = addInBasketService;
		this.bpService = bpService;
	}

	@GetMapping("/selectRestorant - view")
	public String getRestorantSelectedFormReview(Model model,
			@RequestParam(value = "restorantId", required = false) Integer idSelect, Integer idRestorant,
			Integer adminIdWeb) throws Exception {
		model.addAttribute("restorantList", restService.getAllRestorants(adminIdWeb));
		if ((idSelect == null) && (idRestorant == null)) {
			var restorantSelected = new SelectWhichYouPreferForm();
			restorantSelected.setIdSelect(idSelect);
			model.addAttribute("restorantPreferenceForm", restorantSelected);
			model.addAttribute("viewTitle", "Visitor RestorantPrefered_Selected");
		} else {
			model.addAttribute("restorantPreferenceForm", restService.getRestorantById1(idRestorant));
			model.addAttribute("viewTitle", "Visitor RestorantPrefered_Selected");
		}
		return "tailwindcss/selected - form";
	}

	@PostMapping("/select")
	public String saveSelectedPreference(
			@ModelAttribute("restorantPreferenceForm") @Valid SelectWhichYouPreferFormDto restorantSelected,
			Integer idRestorant, Integer idSelect, BindingResult nResult) throws Exception {
		if (nResult.hasErrors()) {
			return "selected - form ";
		}
		if (((RestorantService) restorantSelected).getRestorantById1(idRestorant) == null) {
			restService.selectRestorant(restorantSelected);
		} else {
			restService.updateRprefered(((RestorantService) restorantSelected).getRestorantById1(idRestorant),
					restorantSelected, idSelect);
		}
		return "redirect:/restorant ";
	}

	// MENU
	@GetMapping
	public String getDishesperDishCatReviewList(Model model, Integer idCategoria, Integer adminId) throws Exception {
		model.addAttribute("dish", dishService.getDishesByDishCategory(idCategoria, adminId));
		return "redirect:/dishCategory";
	}

	@GetMapping("/selectDish - form")
	public String getAddInBasketView(Model model,
			@RequestParam(value = "idSession ", required = false) Integer categoryId, Integer adminId,
			Integer customerId, Integer dId, Integer id) throws Exception {
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
		return "redirect:/user/register-view";
	}

	// Rezervoni në restorantin tonë/RestorantTables details~ informacion
	@GetMapping
	public String getRestorantTableDetails(Model model, Integer rtb_id, Integer adminRId) throws Exception {
		model.addAttribute("restorantTables", rTablesService.getRestorantTablesDetails(rtb_id, adminRId));
		return "redirect:/RegisterBookingForm";
	}

	@GetMapping("/reservation - view")
	public String getCustomerReservationView(Model model,
			@RequestParam(value = " restorantTableId ", required = false) Integer idCustomer, Integer cR_Id,
			Integer idRestorant, Integer rtb_id, Integer crId) throws Exception {
		model.addAttribute("restorantTables", rTablesService.getAlltablesById(rtb_id, cR_Id));

		if (crId == null) {
			var reservationR = new RegisterBookingForm();
			reservationR.setCrId(crId);
			model.addAttribute("customerReservationForm", reservationR);
			model.addAttribute("viewTitle", "BookingProcess Registration");
		} else {
			model.addAttribute("customerReservationForm",
					bpService.getCustomerReservationById(idCustomer, cR_Id, idRestorant));
			model.addAttribute("viewTitle", "BookingProcess Update");
		}

		return "tailwindcss/reservation - view ";
	}

	@PostMapping("/register")
	public String registerCustomerReservationForm(
			@ModelAttribute("customerReservationForm") @Valid RegisterBookingFormDto regBooking, BindingResult bresult,
			Integer idCustomer, Integer cR_Id, Integer rtb_id) throws Exception {

		if (bresult.hasErrors()) {
			return "redirect:/reservation - view ";
		}
		if (((BookingProcessingService) regBooking).getCustomerReservationById(idCustomer, cR_Id, rtb_id) == null) {
			bpService.createBooking(regBooking);
		} 

		return "redirect/register - view ";
	}

}