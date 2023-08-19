package com.project.demo.sushiCo.domain.dto;

import com.project.demo.sushiCo.entity.Restorant;
import com.project.demo.sushiCo.entity.UserRole;
import com.project.demo.sushiCo.entity.WebAplication;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDto {

	private Integer id;
	@NotNull(message = " * Required * ")
	@Size(min = 3, message = "Name should be at least 3 characters")
	@NotBlank(message = "First_name ")
	private String first_name;
	@NotNull(message = "* Required *")
	@Size(min = 4, message = "Surname should be at least 4 characters")
	private String last_name;
	@NotBlank(message = "Zona e Sherbimit/Rruga:/Ndertesa nr: /Kati i nderteses/Apartamenti nr ")
	@NotNull(message = " * Required *")
	@Size(min = 20, max = 65, message = "This field should include all components such as : Country/City/Street/Apartment/Apartment no")
	private String address;
	@NotBlank(message = "+355 6000000000")
	@NotNull(message = " * Required *")
	@Size(min = 9, max = 12, message = "PhoneNo is at minimum with 9 characters and at maximin with 12 characters")
	private String phoneNo;
	@NotNull(message = "It's required")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\\\.[a-z]{2,3}")
	private String email;
	@NotNull(message = "It's required")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "Password should be at minimum with 8 characters")
	private String password;
	@NotNull(message = " * Required *")
	@Size(min = 18, message = "This should include always numbers with two characters")
	private Integer age;
	/*
	 * @NotNull(message =
	 * "This field can be null until the condition is completed!")
	 * 
	 * @Size(min = 4, max = 7, message =
	 * "This is at min 4 characters and at max 7 characters") private String
	 * customerType; /*
	 * 
	 * @NotNull(message = "This is Required ")
	 * 
	 * @Size(message =
	 * "This should include eleven characters,where the first and the last character is an upperCase Letter,others are numbers"
	 * )
	 */
	private String personalIdentityNo;
	/* private Double points; */
	@NotNull(message = "It's required")
	private String userStatus;
	@NotNull(message = "It's required")
	private UserRole userRole;
	private Long totalCardBank;
	private Long totalShippers;
	private Integer idAdmin;
	private Long totaldishCategories;
	private long totalAppRests;
	private long totalAddInBaskets;
	private long totalOrders;
	private Long totalReservations;
	private Long totalPackage_Orders;
	private Restorant restorant;
	private Long totalOrders1;
	private Integer adminIdPlatforma;
	private String platformaName;
	private Integer userApplId;
	private String webAppname;
	private Long totalUser1;
	private WebAplication webAppl;
	private Long totalRst;

	public UserDto() {
		age = 28;
	}

	public UserDto(Integer id, String first_name, String last_name, String address, String phoneNo, String email,
			String password, Integer age, String personalIdentityNo, String userStatus, UserRole userRole,
			Long totalCardBank, Long totalShippers, Integer idAdmin, Long totaldishCategories, Long totalAppRests,
			Long totalAddInBaskets, Long totalOrders, Long totalReservations, Long totalPackage_Orders,
			Restorant restorant, Integer userApplId, String webAppname, Long totalOrders1, Integer adminIdPlatforma,
			String platformaName, Long totalUser1, WebAplication webAppl, Long totalRst) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.password = password;
		this.age = age;
		this.personalIdentityNo = personalIdentityNo;
		this.setUserStatus(userStatus);
		this.userRole = userRole;
		this.totalCardBank = totalCardBank;
		this.setIdAdmin(idAdmin);
		this.totaldishCategories = totaldishCategories;
		this.setTotalAppRests(totalAppRests);
		this.setTotalAddInBaskets(totalAddInBaskets);
		this.setTotalOrders(totalOrders);
		this.setTotalReservations(totalReservations);
		this.setTotalPackage_Orders(totalPackage_Orders);
		this.userApplId = userApplId;
		this.webAppname = webAppname;
		this.restorant = restorant;
		this.totalOrders1 = totalOrders1;
		this.adminIdPlatforma = adminIdPlatforma;
		this.platformaName = platformaName;
		this.totalUser1 = totalUser1;
		this.webAppl = webAppl;
		this.totalRst = totalRst;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPersonalIdentityNo() {
		return personalIdentityNo;
	}

	public void setPersonalIdentityNo(String personalIdentityNo) {
		this.personalIdentityNo = personalIdentityNo;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole2) {
		this.userRole = userRole2;
	}

	public Long getTotalCardBank() {
		return totalCardBank;
	}

	public void setTotalCardBank(Long totalCardBank) {
		this.totalCardBank = totalCardBank;
	}

	public Long getTotalShippers() {
		return totalShippers;
	}

	public void setTotalShippers(Long totalShippers) {
		this.totalShippers = totalShippers;
	}

	public Integer getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Integer idAdmin) {
		this.idAdmin = idAdmin;
	}

	public Long getTotaldishCategories() {
		return totaldishCategories;
	}

	public void setTotaldishCategories(Long totaldishCategories) {
		this.totaldishCategories = totaldishCategories;
	}

	public long getTotalAppRests() {
		return totalAppRests;
	}

	public void setTotalAppRests(long totalAppRests) {
		this.totalAppRests = totalAppRests;
	}

	public long getTotalAddInBaskets() {
		return totalAddInBaskets;
	}

	public void setTotalAddInBaskets(long totalAddInBaskets) {
		this.totalAddInBaskets = totalAddInBaskets;
	}

	public long getTotalOrders() {
		return totalOrders;
	}

	public void setTotalOrders(long totalOrders) {
		this.totalOrders = totalOrders;
	}

	public Long getTotalReservations() {
		return totalReservations;
	}

	public void setTotalReservations(Long totalReservations) {
		this.totalReservations = totalReservations;
	}

	public Long getTotalPackage_Orders() {
		return totalPackage_Orders;
	}

	public void setTotalPackage_Orders(Long totalPackage_Orders) {
		this.totalPackage_Orders = totalPackage_Orders;
	}

	public Integer getUserApplId() {
		return userApplId;
	}

	public void setUserApplId(Integer userApplId) {
		this.userApplId = userApplId;
	}

	public String getWebAppname() {
		return webAppname;
	}

	public void setWebAppname(String webAppname) {
		this.webAppname = webAppname;
	}

	public Restorant getRestorant() {
		return restorant;
	}

	public void setRestorant(Restorant restorant) {
		this.restorant = restorant;
	}

	public Long getTotalOrders1() {
		return totalOrders1;
	}

	public void setTotalOrders1(Long totalOrders1) {
		this.totalOrders1 = totalOrders1;
	}

	public Integer getAdminIdPlatforma() {
		return adminIdPlatforma;
	}

	public void setAdminIdPlatforma(Integer adminIdPlatforma) {
		this.adminIdPlatforma = adminIdPlatforma;
	}

	public String getPlatformaName() {
		return platformaName;
	}

	public void setPlatformaName(String platformaName) {
		this.platformaName = platformaName;
	}

	public Long getTotalUser1() {
		return totalUser1;
	}

	public void setTotalUser1(Long totalUser1) {
		this.totalUser1 = totalUser1;
	}

	public WebAplication getWebAppl() {
		return webAppl;
	}

	public void setWebAppl(WebAplication webAppl) {
		this.webAppl = webAppl;
	}

	public Long getTotalRst() {
		return totalRst;
	}

	public void setTotalRst(Long totalRst) {
		this.totalRst = totalRst;
	}

	public String toString() {
		return "UserDto[id = " + id + ",first_name = " + first_name + ",last_name = " + last_name + ",address = "
				+ address + ", phoneNo = " + phoneNo + ", email = " + email + ",password = " + password + ",age = "
				+ age + ",personalIdentityNo = " + personalIdentityNo + ",userStatus = " + userStatus + ",userRole = "
				+ userRole + ",totalCardBank = " + totalCardBank + ",idAdmin =" + idAdmin + ",totalShippers = "
				+ totalShippers + ",totaldishCategories = " + totaldishCategories + ",totalAppRests = " + totalAppRests
				+ ",totalAddInBaskets = " + totalAddInBaskets + ",totalOrders =" + totalOrders
				+ ",Long totalReservations = " + totalReservations + ",totalPackage_Orders = " + totalPackage_Orders
				+ ",webAppId = " + userApplId + ",webAppname = " + webAppname + ",restorant = " + restorant
				+ ",totalOrders1 = " + totalOrders1 + ",adminIdPlatforma = " + adminIdPlatforma + ",platformaName = "
				+ platformaName + ",totalUser1 = " + totalUser1 + ",webAppl = " + webAppl + ",totalRst = " + totalRst
				+ "]";
	}

}
