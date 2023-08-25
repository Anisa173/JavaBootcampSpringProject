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

import com.project.demo.sushiCo.domain.dto.OrderByProcessingDto;
import com.project.demo.sushiCo.domain.dto.RegisterCardBankDto;
import com.project.demo.sushiCo.domain.dto.SelectDishesFormDto;
import com.project.demo.sushiCo.domain.dto.SelectWhichYouPreferFormDto;
import com.project.demo.sushiCo.service.AddInBasketService;
import com.project.demo.sushiCo.service.DishService;
import com.project.demo.sushiCo.service.OrderByProcessing;
import com.project.demo.sushiCo.service.PaymentMethodsService;
import com.project.demo.sushiCo.service.RegisterCardform;
import com.project.demo.sushiCo.service.RestorantService;
import com.project.demo.sushiCo.service.SelectDishesForm;
import com.project.demo.sushiCo.service.SelectWhichYouPreferForm;
import com.project.demo.sushiCo.service.ServicePlacesService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/customer")
public class CustomerController {

	@GetMapping
	public String getCustomerIndexView(Authentication auth, Model model) {
		model.addAttribute("isAuthenticated", auth != null);
		return "index";
	}

	@Autowired
	private final RestorantService restService;
	private final DishService dishService;
	private final AddInBasketService addInBasketService;
	private final PaymentMethodsService pmethodService;
	private final ServicePlacesService sPlacesService;

	public CustomerController(RestorantService restService, DishService dishService,
			AddInBasketService addInBasketService, PaymentMethodsService pmethodService,
			ServicePlacesService sPlacesService) {
		this.restService = restService;
		this.dishService = dishService;
		this.addInBasketService = addInBasketService;
		this.pmethodService = pmethodService;
		this.sPlacesService = sPlacesService;
	}

	@GetMapping("/selectRestorant - view")
	public String getRestorantSelectedFormReview(Model model,
			@RequestParam(value = "restorantId", required = false) Integer idSelect, Integer userId,
			Integer idRestorant) throws Exception {
		if ((idSelect == null) && (idRestorant == null)) {
			var restorantSelected = new SelectWhichYouPreferForm();
			restorantSelected.setIdSelect(idSelect);
			model.addAttribute("restorantPreferenceForm", restorantSelected);
			model.addAttribute("viewTitle", "Visitor RestorantPrefered_Selected");
		} else {
			model.addAttribute("restorantPreferenceForm", restService.getCustomerRestorantById(userId, idRestorant));
			model.addAttribute("viewTitle", "Visitor RestorantPrefered_Updated");
		}
		return "tailwindcss/selected - form";
	}

	@PostMapping("/select")
	public String saveSelectedPreference(
			@ModelAttribute("restorantPreferenceForm") @Valid SelectWhichYouPreferFormDto restorantSelected,
			Integer userId, Integer idRestorant, Integer idSelect, BindingResult nResult) throws Exception {
		if (nResult.hasErrors()) {
			return "selected - form ";
		}
		if (((RestorantService) restorantSelected).getCustomerRestorantById(userId, idRestorant) == null) {
			restService.selectRestorant(restorantSelected);
		} else {
			restService.updateRprefered(
					((RestorantService) restorantSelected).getCustomerRestorantById(userId, idRestorant),
					restorantSelected, idSelect);
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
			model.addAttribute("viewTitle", "Update Selected Dishes");

		}

		return "tailwindcss/selected - form ";
	}

	@PostMapping("/register")
	public String saveSelectedDishesInBasket(
			@ModelAttribute("AddInBasket") @Valid SelectDishesFormDto selectDishesInBasket, BindingResult result,
			Integer categoryId, Integer adminId, Integer customerId, Integer dId) throws Exception {
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
		return "redirect:/user/addInBasket";
	}

	@GetMapping("/orderProcessing - view")
	public String getOrderProcessingView(Model model, @RequestParam(value = "idSession", required = false) Integer dId,
			Integer categoryId, Integer custId, Integer idRestorant, Integer idSession, Integer pmId, Integer servPId)
			throws Exception {
		model.addAttribute("addInBasket", addInBasketService.getDishesByCustomerId(dId, categoryId, custId));
		model.addAttribute("paymentMethods", pmethodService.getRestorantPMethods(idRestorant));
		model.addAttribute("servicePlaces ", sPlacesService.getRestorantPServices(idRestorant));
		if (idSession == null) {
			var orderSession = new OrderByProcessing();
			orderSession.setIdSession(idSession);
			model.addAttribute("order_processingForm", orderSession);
			model.addAttribute("viewTitle", "Order Processed!");
		} else {
			model.addAttribute("order_processingForm",
					addInBasketService.getPaymentServicesCustomById(custId, idRestorant, pmId, servPId));
			model.addAttribute("viewTitle", "Order_Details Updated");
		}
		return "tailwindcss/order_processed - view";
	}

	@PostMapping("/register")
	public String saveOrderDetails(
			@ModelAttribute("order_processingForm") @Valid OrderByProcessingDto orderByProcessForm,
			BindingResult bResult, Integer custId, Integer idRestorant, Integer pmId, Integer servPId)
			throws Exception {

		if (bResult.hasErrors()) {
			return "redirect:/orderProcessing - view ";
		}
		if (((AddInBasketService) orderByProcessForm).getPaymentServicesCustomById(custId, idRestorant, pmId,
				servPId) == null) {
			addInBasketService.createByProcessing(orderByProcessForm);
		} else {
			addInBasketService.updateByProcessing(((AddInBasketService) orderByProcessForm)
					.getPaymentServicesCustomById(custId, idRestorant, pmId, servPId), orderByProcessForm, custId,
					idRestorant, pmId, servPId);
		}

		return "redirect:/order";
	}

	@GetMapping("/cardData - view")
	public String getCardPaymentView(Model model,
			@RequestParam(value = "paymentCardId ", required = false) Integer registrationId, Integer custId,
			Integer idRestorant, Integer pmId, Integer servPId) throws Exception {
		if (registrationId == null) {

			var cardPaymentDish = new RegisterCardform();
			cardPaymentDish.setRegistrationId(registrationId);
			model.addAttribute("cardBankForm", cardPaymentDish);
			model.addAttribute("viewTitle", "Card_Bank Registration");
		} else {
			model.addAttribute("cardBankForm ",
					addInBasketService.getCardsByCustomerId(registrationId, custId, idRestorant, pmId, servPId));
			model.addAttribute("viewTitle", " Pay with cash");
		}

		return "tailwindcss/registration - card";
	}

	@PostMapping("/register")
	public String saveCardPaymentDetails(@ModelAttribute("cardBankForm") @Valid RegisterCardBankDto regCardBank,
			BindingResult bResult, Integer registrationId, Integer custId, Integer idRestorant, Integer pmId,
			Integer servPId) throws Exception {
		if (bResult.hasErrors()) {
			return " redirect:/cardData - view ";
		}
		if (((AddInBasketService) regCardBank).getCardsByCustomerId(registrationId, custId, idRestorant, pmId,
				servPId) == null) {
			addInBasketService.createOrderPaymentDetails(regCardBank);
		}

		else {
			addInBasketService.deleteCardPaymentDetails(((AddInBasketService) regCardBank)
					.getCardsByCustomerId(registrationId, custId, idRestorant, pmId, servPId), custId, idRestorant,
					pmId, servPId, registrationId, regCardBank);
		}

		return "redirect/order ";
	}

}
