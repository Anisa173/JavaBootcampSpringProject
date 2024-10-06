package com.project.demo.sushiCo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.demo.sushiCo.domain.dto.OrderDto;
import com.project.demo.sushiCo.domain.dto.PaymentMethodsDto;
import com.project.demo.sushiCo.domain.dto.RestorantDto;
import com.project.demo.sushiCo.domain.dto.ServicePlacesDto;
import com.project.demo.sushiCo.service.OrderService;
import com.project.demo.sushiCo.service.PaymentMethodsService;
import com.project.demo.sushiCo.service.RegisterMethodsPaymentForm;
import com.project.demo.sushiCo.service.RegisterRestorantForm;
import com.project.demo.sushiCo.service.RegisterServicePlacesForm;
import com.project.demo.sushiCo.service.RestorantService;
import com.project.demo.sushiCo.service.ServicePlacesService;
import com.project.demo.sushiCo.service.UserService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/Administrator")
public class AdministratorController {

	@Autowired
	private final UserService userService;
	private final RestorantService restService;
	private final PaymentMethodsService pmService;
	private final ServicePlacesService sPlacesService;
	private final OrderService oService;

	public AdministratorController(UserService userService, RestorantService restService,
			PaymentMethodsService pmService, ServicePlacesService sPlacesService, OrderService oService) {
		this.userService = userService;
		this.restService = restService;
		this.pmService = pmService;
		this.sPlacesService = sPlacesService;
		this.oService = oService;
	}

	@GetMapping
	public String getAdministratorIndexView(Authentication auth, Model model) throws Exception {
		model.addAttribute("isAuthenticated", auth != null);
		return "index";
	}

	@GetMapping
	public String getUserReviewList(Model model) throws Exception {
		model.addAttribute(" user ", userService.getAllUser());
		return " tailwindcss/user - List ";
	}

	@GetMapping
	public String getShipperReviewList(Model model, Integer id) throws Exception {
		model.addAttribute("shippers", userService.getAllShippersByAdminId(id));
		return " tailwindcss/user -list ";
	}

	@DeleteMapping
	public String deleteAdmin(@RequestParam(value = "userId", required = true) Integer id) throws Exception {
		userService.deleteAdmin(id);
		return "redirect:/user -List ";
	}

	@DeleteMapping
	public String deleteShipper(@RequestParam(value = "userId", required = true) Integer id) throws Exception {
		userService.deleteShippers(id);
		return "redirect:/user -List ";
	}

	@GetMapping
	public String getCustomersReviewList(Model model, Integer id) throws Exception {
		model.addAttribute(" customer ", userService.getAllCustomers(id));
		return "redirect/user -List";
	}

	@GetMapping("/restorant/register - view")
	public String getRestorantRegistrationView(Model model,
			@RequestParam(value = "userId", required = false) Integer idRestorant) throws Exception {
		if (idRestorant == null) {
			model.addAttribute("restorantForm", new RegisterRestorantForm());
			model.addAttribute("viewTitle", "Restorant Registration");
		} else {
			model.addAttribute("restorantForm", restService.getRestorantsById(idRestorant));
			model.addAttribute("viewTitle", "Restorant Update");
		}

		return "tailwindcss/registration - form";
	}

	@PostMapping("/restorant/register")
	public String register(@ModelAttribute("restorantForm") @Valid RestorantDto restForm, BindingResult bResult,
			Integer idRestorant) throws Exception {
		if (bResult.hasErrors()) {
			return "redirect:/register - view ";
		}
		if (((RestorantService) restForm).getRestorantsById(idRestorant) == null) {
			restService.create(restForm);
		} else {
			restService.update(((RestorantService) restForm).getRestorantsById(idRestorant), restForm, idRestorant);
		}
		return "redirect:/restorant";
	}

	@GetMapping("/paymentMethods/register - view")
	public String getPmRegistrationView(Model model, @RequestParam(value = "paymentM_Id", required = false) Integer Id,
			Integer idRestorant) throws Exception {
		if (Id == null) {
			model.addAttribute("payment_methodForm", new RegisterMethodsPaymentForm());
			model.addAttribute("viewTitle", "Restorant Payment_methods registration");
		} else {
			model.addAttribute("payment_methodForm", pmService.getPayment_MethodsById(Id, idRestorant));
			model.addAttribute("viewTitle", "Payment_Methods Update");
		}
		return "tailwindcss/registration - form ";
	}

	@PostMapping("/paymentMethods/register")
	public String saveRestorantPmForm(@ModelAttribute("payment_methodForm") @Valid PaymentMethodsDto pmForm,
			BindingResult bResult, Integer Id, Integer idRestorant) throws Exception {
		if (bResult.hasErrors()) {
			return "redirect:/register - view ";
		}
		if (((PaymentMethodsService) pmForm).getPayment_MethodsById(Id, idRestorant) == null) {
			pmService.create(pmForm);
		} else {
			((PaymentMethodsService) pmService).update(
					((PaymentMethodsService) pmForm).getPayment_MethodsById(Id, idRestorant), pmForm, Id, idRestorant);
		}
		return "redirect:/paymentMethods ";
	}

	@GetMapping("/servicePlaces/register - view")
	public String getRestServPRegistartionView(Model model,
			@RequestParam(value = "serviceP_Id", required = false) Integer Id, Integer idRestorant) throws Exception {
		if (Id == null) {
			model.addAttribute("service_PlForm", new RegisterServicePlacesForm());
			model.addAttribute("viewTitle ", " Restorant Service_Places Form");
		} else {
			model.addAttribute("service_PlForm", sPlacesService.getService_PlacesById(Id, idRestorant));
			model.addAttribute("viewTitle", " Restorant Service_Places Modification");
		}
		return "tailwindcss/registration - form ";
	}

	@PostMapping("/servicePlaces/register")
	public String saveRestorantSpForm(@ModelAttribute("service_PlForm") @Valid ServicePlacesDto sPlaces,
			BindingResult bResult, Integer Id, Integer idRestorant) throws Exception {
		if (bResult.hasErrors()) {
			return "redirect:/registration - form";
		}
		if (((ServicePlacesService) sPlaces).getService_PlacesById(Id, idRestorant) == null) {
			sPlacesService.create(sPlaces);
		} else {
			sPlacesService.update(Id, idRestorant,
					((ServicePlacesService) sPlaces).getService_PlacesById(Id, idRestorant), sPlaces);
		}

		return "redirect:/ServicePlaces";
	}

	@GetMapping
	public String getRestorantDetails(Model model, Integer idRestorant) throws Exception {
		model.addAttribute("restorant", restService.getRestorantDetails(idRestorant));
		return "redirect:/dish ";
	}

	@GetMapping
	public String getRestorantsReviewlist(Model model, Integer adminIdWeb) throws Exception {
		model.addAttribute(" restorant ", restService.getAllRestorants(adminIdWeb));
		return "redirect:/restorant -List ";
	}

	@GetMapping
	public String getOrderConfirmed(Model model, @Valid OrderDto oDto) throws Exception {
		model.addAttribute("order", oService.createOrder(oDto));
		return "redirect:/order";
	}

	// Admini i aplikacionit 'sheh' porositë sipas customerId dhe datës së
	// proçesimit per arsye analitike
	@GetMapping
	public String getOrderListReview(Model model) throws Exception {
		model.addAttribute("order", oService.getOrders());
		return "redirect:/user";
	}

	@DeleteMapping("/restorant/delete/idRestorant")
	public String delete(@RequestParam(value = "idRestorant", required = true) Integer idRestorant, Integer adminIdWeb)
			throws Exception {
		restService.delete(idRestorant, adminIdWeb);
		return "redirect:/restorantList";
	}

}
