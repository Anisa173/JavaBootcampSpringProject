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
import com.project.demo.sushiCo.domain.dto.DishCategoryDto;
import com.project.demo.sushiCo.domain.dto.RegisterDishFormDto;
import com.project.demo.sushiCo.domain.dto.RestorantTablesDto;
import com.project.demo.sushiCo.domain.dto.TransportingPackageOrderFormDto;
import com.project.demo.sushiCo.service.DishCategoryService;
import com.project.demo.sushiCo.service.DishService;
import com.project.demo.sushiCo.service.OrderService;
import com.project.demo.sushiCo.service.PackageOrderedService;
import com.project.demo.sushiCo.service.RegisterCategoryDishForm;
import com.project.demo.sushiCo.service.RegisterRestorantTablesForm;
import com.project.demo.sushiCo.service.RestorantTablesService;
import com.project.demo.sushiCo.service.TransportingPackageOrderForm;
import com.project.demo.sushiCo.serviceImpl.RegisterDishForm;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/Admin")
public class AdminController {

	@Autowired
	private final DishCategoryService dcService;
	@Autowired
	private final DishService dService;
	@Autowired
	private final OrderService oService;
	@Autowired
	private final RestorantTablesService rtbService;
	@Autowired
	private final PackageOrderedService pcgService;

	public AdminController(DishCategoryService dcService, DishService dService, OrderService oService,
			RestorantTablesService rtbService, PackageOrderedService pcgService) {
		this.dcService = dcService;
		this.dService = dService;
		this.oService = oService;
		this.rtbService = rtbService;
		this.pcgService = pcgService;
	}

	@GetMapping
	public String getAdminIndexView(Authentication auth, Model model) {
		model.addAttribute("isAuthenticated", auth != null);
		return "index";
	}

	@GetMapping("/categoryDish/register-view")
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

	@PostMapping("/categoryDish/register")
	public String registerCategory(@ModelAttribute("dish_categoryForm") @Valid DishCategoryDto dcDto,
			BindingResult result, Integer id, Integer adminId) throws Exception {
		if (result.hasErrors()) {
			return "redirect:/registration - form";
		}
		if (((DishCategoryService) dcDto).getDishCategoryById(id, adminId) == null) {
			dcService.create(dcDto);
		} else {
			dcService.update(((DishCategoryService) dcDto).getDishCategoryById(id, adminId), id, adminId);
		}
		return "redirect:/DishCategory ";
	}

	@GetMapping("/categoryDish/delete")
	public String delete(@RequestParam(value = " categoryId ", required = true) Integer id, Integer adminId)
			throws Exception {
		dcService.delete(id, adminId);

		return " redirect:/dishcategory";
	}

	@GetMapping
	public String getDishCategoryReviewList(Model model, Integer adminId) throws Exception {
		model.addAttribute("DishCategory", dcService.getDishCategorybyRestorant(adminId));
		return "redirect:/dishcategory ";
	}

	@GetMapping("/dish/register-view")
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

	@PostMapping("/dish/register")
	public String saveRegistrationDish(@ModelAttribute("dishForm") @Valid RegisterDishFormDto regDishForm,
			BindingResult bResult, Integer dId, Integer categoryId, Integer adminId) throws Exception {
		if (bResult.hasErrors()) {
			return "redirect:/registration - form";
		}

		if (((DishService) regDishForm).getDishByDishCategory(dId, categoryId, adminId) == null) {
			dService.create(regDishForm);
		} else {
			dService.update(((DishService) regDishForm).getDishByDishCategory(dId, categoryId, adminId),
					adminId, categoryId, dId);
		}
		return "redirect:/Dish ";
	}

	@GetMapping
	public String getDishesRequiredListReview(Model model, Integer adminId) throws Exception {
		model.addAttribute("dish", dService.getDishByPreferences(adminId));
		return "redirect:/dish ";
	}

	@GetMapping
	public String getRestDishMostRequired(Model model, Integer dId, Integer id) throws Exception {
		model.addAttribute("dish", dService.getMaxPreference(dId, id));
		return "redirect:/dish";
	}

	@GetMapping
	public String getDishList(Model model, Integer categoryId, Integer adminId) throws Exception {
		model.addAttribute("dish", dService.getDishesByDishCategory(categoryId, adminId));
		return "redirect:/dish";
	}

	@GetMapping("/order/delete")
	public String deleteOrder(@RequestParam(value = "OrderId", required = true) Integer adminRestId, Integer oId)
			throws Exception {
		oService.deleteOrder(adminRestId, oId);
		return "redirect:/orderList ";
	}

	// Admini i restorantit rendit porosite sipas kostos ASC apo DESC te grupuara
	// per çdo klient
	@GetMapping
	public String getOrdersList(Model model, Integer id) throws Exception {
		model.addAttribute("Order", oService.getOrdersByCost(id));
		return "redirect:/order";
	}

	// Admini i restorantit kërkon të gjenerojë porosinë me koston më të madhe ose
	// më të vogël si edhe kush e kryer atë
	@GetMapping
	public String getOrderEconomicValues(Model model, Integer idRestorant, Integer userId) throws Exception {
		model.addAttribute("Order", oService.getOrderMaxMinByCustomerId(idRestorant, userId));
		return "redirect:/orderList ";
	}

	@GetMapping("/restorantTables/register-view")
	public String getRstTablesRegistrationView(Model model,
			@RequestParam(value = "restorantTableId ", required = false) Integer idRegistration, Integer tb_id,
			Integer rtb_id, Integer adminRId) throws Exception {
		if ((idRegistration == null) && (rtb_id == null)) {
			var restTable = new RegisterRestorantTablesForm();
			restTable.setIdRegistration(idRegistration);
			model.addAttribute("rTableForm", restTable);
			model.addAttribute("viewTitle", "Restorant_Table Register");
		} else {
			model.addAttribute("rTableForm", rtbService.getRestorant_tablesById(tb_id, rtb_id, adminRId));
			model.addAttribute("viewTitle", "Update Restorant_Table ");
		}
		return "tailwindcss/register - view ";
	}

	@PostMapping("/restorantTables/register")
	public String saveTableRestForm(@ModelAttribute("rTableForm") @Valid RestorantTablesDto restTdto,
			BindingResult bResult, Integer tb_id, Integer rtb_id, Integer adminRId) throws Exception {
		if (bResult.hasErrors()) {
			return "redirect:/register - view";
		}
		if (((RestorantTablesService) restTdto).getRestorant_tablesById(tb_id, rtb_id, adminRId) == null) {
			rtbService.create(restTdto);
		} else {
			rtbService.update(tb_id, rtb_id, adminRId,
					((RestorantTablesService) restTdto).getRestorant_tablesById(tb_id, rtb_id, adminRId));
		}

		return "redirect:/restorantTables ";
	}

	@DeleteMapping
	public String delete(@RequestParam(value = "tableId", required = true) Integer tableId, Integer rtbId,
			Integer idRestorant) throws Exception {
		rtbService.delete(tableId, rtbId, idRestorant);
		return "redirect:/restorantTables ";
	}

	@GetMapping("/packageOrdered/packageOrder - view")
	public String getPackageOrderForm(Model model,
			@RequestParam(value = " idPackagedOrder ", required = false) Integer registrationId, Integer userId,
			Integer serviceId, Integer idShporta) throws Exception {
		model.addAttribute(" order ", oService.getOrdersById(userId));
		if (registrationId == null) {
			var packReg = new TransportingPackageOrderForm();
			packReg.setRegistrationId(registrationId);
			model.addAttribute("packageOrderForm", packReg);
			model.addAttribute("viewTitle", "PackageOrder Created");
		} else {
			model.addAttribute("packageOrderForm", pcgService.getPackageOrderById(userId, serviceId, idShporta));
			model.addAttribute("viewTitle", " PackageOrder Updated");
		}
		return "tailwindcss/packageOrder - view";
	}

	@PostMapping("/packageOrdered/register")
	public String savePackageOrderCreated(
			@ModelAttribute("packageOrderForm") @Valid TransportingPackageOrderFormDto shippingPackOrder,
			BindingResult br, Integer idShporta, Integer serviceId, Integer oId, Integer userId) throws Exception {
		if (br.hasErrors()) {
			return "packageOrder - view ";
		}
		if ((pcgService).getPackageOrderById(userId, serviceId, idShporta) == null) {
			pcgService.create(shippingPackOrder);
		} else {
			pcgService.update(
					((PackageOrderedService) shippingPackOrder).getPackageOrderById(userId, serviceId, idShporta),
					 idShporta, serviceId, oId, userId);
		}

		return "redirect:/packageOrder ";
	}

}
