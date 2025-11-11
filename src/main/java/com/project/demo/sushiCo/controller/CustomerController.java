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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.demo.sushiCo.domain.dto.OrderByProcessingDto;
import com.project.demo.sushiCo.domain.dto.RegisterBookingFormDto;
import com.project.demo.sushiCo.domain.dto.RegisterCardBankDto;
import com.project.demo.sushiCo.domain.dto.SelectDishesFormDto;
import com.project.demo.sushiCo.domain.dto.TransportingPackageOrderFormDto;
import com.project.demo.sushiCo.service.AddInBasketService;
import com.project.demo.sushiCo.service.BookingProcessingService;
import com.project.demo.sushiCo.service.DishService;
import com.project.demo.sushiCo.service.OrderByProcessing;
import com.project.demo.sushiCo.service.OrderService;
import com.project.demo.sushiCo.service.PackageOrderedService;
import com.project.demo.sushiCo.service.PaymentMethodsService;
import com.project.demo.sushiCo.service.RegisterBookingForm;
import com.project.demo.sushiCo.service.RegisterCardform;
import com.project.demo.sushiCo.service.RestorantService;
import com.project.demo.sushiCo.service.RestorantTablesService;
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
	private final RestorantTablesService rTablesService;
	@Autowired
	private final RestorantService restService;
	@Autowired
	private final DishService dishService;
	@Autowired
	private final AddInBasketService addInBasketService;
	@Autowired
	private final BookingProcessingService bpService;
	@Autowired
	private final PaymentMethodsService pmethodService;
	@Autowired
	private final ServicePlacesService sPlacesService;
	@Autowired
	private final OrderService oService;
	@Autowired
	private final PackageOrderedService pcgService;

	public CustomerController(RestorantTablesService rTablesService, RestorantService restService,
			DishService dishService, AddInBasketService addInBasketService, BookingProcessingService bpService,
			PaymentMethodsService pmethodService, ServicePlacesService sPlacesService, OrderService oService,
			PackageOrderedService pcgService) {
		this.rTablesService = rTablesService;
		this.restService = restService;
		this.dishService = dishService;
		this.addInBasketService = addInBasketService;
		this.bpService = bpService;
		this.pmethodService = pmethodService;
		this.sPlacesService = sPlacesService;
		this.oService = oService;
		this.pcgService = pcgService;
	}

	@GetMapping("/restorant/selectRestorant - view")
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

	@PostMapping("/restorant/select")
	public String saveSelectedPreference(
			@ModelAttribute("restorantPreferenceForm") @Valid SelectWhichYouPreferForm restorantSelected,
			Integer userId, Integer idRestorant, Integer idSelect, BindingResult nResult) throws Exception {
		if (nResult.hasErrors()) {
			return "selected - form ";
		}
		if (((RestorantService) restorantSelected).getCustomerRestorantById(userId, idRestorant) == null) {
			restService.selectRestorantByCustomer(restorantSelected);
		} else {
			restService.updateRprefered(
                    ((RestorantService) restorantSelected).getCustomerRestorantById(userId, idRestorant), idSelect);
		}
		return "redirect:/restorant ";
	}

	@GetMapping
	public String getDishesperDishCatReviewList(Model model, Integer idCategoria, Integer adminId) throws Exception {
		model.addAttribute("dish", dishService.getDishesByDishCategory(idCategoria, adminId));
		return " redirect:/dishCategory";
	}

	@GetMapping("/addInBasket/selectDish - form")
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

	@PostMapping("/addInBasket/register")
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
					categoryId, customerId), dId, categoryId, customerId);

			addInBasketService.delete(((AddInBasketService) selectDishesInBasket).getDishDCategoriesByCustomerId(dId,
					categoryId, customerId), dId);

		}
		return "redirect:/user/addInBasket";
	}

	@GetMapping("/order/orderProcessing - view")
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

	@PostMapping("/order/register")
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
					.getPaymentServicesCustomById(custId, idRestorant, pmId, servPId), custId,
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
		} else {
			addInBasketService.deleteCardPaymentDetails(((AddInBasketService) regCardBank)
					.getCardsByCustomerId(registrationId, custId, idRestorant, pmId, servPId), custId, idRestorant,
					pmId, servPId, registrationId);
		}
		return "redirect/order ";
	}

	@PutMapping("/{idShporta}")
	public String confirmOrderProcessed(@RequestParam(value = "orderId ", required = true) @Valid TransportingPackageOrderFormDto shippingPackOrder,
			Integer userId, Integer serviceId, Integer idShporta, Integer oId) throws Exception {
		pcgService.updateByStatus(
				((PackageOrderedService) shippingPackOrder).getPackageOrderById(userId, serviceId, idShporta),
				 idShporta, serviceId, oId, userId);

		return "redirect:/order ";
	}

	@DeleteMapping
	public String delete(@RequestParam(value = "orderId ", required = true) Integer id,
			Integer oId) throws Exception {
		oService.cancelUserOrder(id, oId);
		return "redirect:/orderList";
	}

	// Çdo klient duhet të shohë porositë që ka kryer në çdo restorant të grupuara
	// sipas emrit te restorantit
	@GetMapping
	public String getRestorantsOrderListReview(Model model, Integer customerId) throws Exception {
		model.addAttribute("order", oService.getOrdersRByCustomerId(customerId));
		return "redirect:/orderList ";
	}

	// Çdo klient duhet të shohë porositë që ka kryer në çdo restorant në këtë
	// aplikacion sipas kohës qe jane kryer
	@GetMapping
	public String getCustomerOrderList(Model model, Integer customerId, Integer idRest, String restName)
			throws Exception {
		model.addAttribute("order", oService.getOrdersByRestorantId(customerId, idRest, restName));

		return "redirect:/orderList";
	}

// Çdo klient te shohe ne profilin e tij te gjitha porosite qe ka kryer ne njerin prej restoranteve
	@GetMapping
	public String getRestOrderList(Model model, Integer idCustomer, Integer idRest) throws Exception {
		model.addAttribute("Order", oService.getOrdByRestorantId(idCustomer, idRest));
		return "redirect:/orderList";
	}

	// Rezervoni në restorantin tonë/RestorantTables details~ informacion
	@GetMapping
	public String getRestorantTableDetails(Model model, Integer rtb_id, Integer adminRId) throws Exception {
		model.addAttribute("restorantTables", rTablesService.getRestorantTablesDetails(rtb_id, adminRId));
		return "redirect:/RegisterBookingForm";
	}

	@GetMapping("/bookingProcessing/reservation - view")
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

	@PostMapping("/bookingProcessing/register")
	public String registerCustomerReservationForm(
			@ModelAttribute("customerReservationForm") @Valid RegisterBookingFormDto regBooking, BindingResult bresult,
			Integer idCustomer, Integer cR_Id, Integer rtb_id) throws Exception {

		if (bresult.hasErrors()) {
			return "redirect:/reservation - view ";
		}
		if (((BookingProcessingService) regBooking).getCustomerReservationById(idCustomer, cR_Id, rtb_id) == null) {
			bpService.createBooking(regBooking);
		} else {
			bpService.update(
					((BookingProcessingService) regBooking).getCustomerReservationById(idCustomer, cR_Id, rtb_id));
		}

		return "redirect/bookingProcessing";
	}

	@GetMapping("/delete")
	public String delete1(@RequestParam(value = "bookingId ", required = true) Integer id, Integer cR_id,
			Integer idRestorant) throws Exception {
		bpService.deleteReservation(id, cR_id, idRestorant);
		return "redirect:/bookingProcessing";
	}

	@GetMapping
	public String getRestorantCustReservations(Model model,Integer id, Integer cR_Id, Integer rtb_id)
			throws Exception {

		model.addAttribute("bookingProcessing", bpService.getCustomerReservationById(id, cR_Id, rtb_id));
		return "redirect:/bookingProcessing";
	}

	@GetMapping
	public String getAllReservations(Model model, Integer id, Integer cR_Id)
			throws Exception {
		model.addAttribute("bookingProcessing", bpService.getAllCustomerReservationById(id, cR_Id));
		return "redirect:/bookingProcessing ";
	}

}
