package com.project.demo.sushiCo.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class User extends BasicEntity<Integer> implements UserDetails {

	private static final long serialVersionUID = 6350320748155867627L;
    
	//Te gjithe userat survejohen nga administratori i platformës
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "adminIdPlatforma ", referencedColumnName = "idAppl ")
	private User AdminPlatforma;

     //N-kliente zgjedhin te regjistrohen,logohen apo preferojne te perdorin aplikacionin tone	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "userApplId ", referencedColumnName = "idAppl ")
	private WebAplication webAplication;

	// Cdo admin menaxhon porosite e restorantit te tij
	@OneToMany(mappedBy = "adminUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Order> orders1 = new ArrayList<Order>();

	// Secilit admin i perket nje restorant
	@OneToOne(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonBackReference
	private Restorant restorant;

	// Çdo admin menaxhon disa kategori menush
	@OneToMany(mappedBy = "User", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<DishCategory> dishCategories = new ArrayList<>();

	// Çdo user mund te posedoje nje ose disa karta banke
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CardBank> cardBank = new ArrayList<CardBank>();

	// Admini i restorantit 'X' e realizon transportin ndërurban të porosive
	// nepermjet 'shippersave' te tij
	@OneToMany(mappedBy = "shippers", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<User> user = new ArrayList<User>();

	// Disa transportues te restorantit i pergjigjen porosive te adminit
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idAdmin", referencedColumnName = "id")
	private User shippers;

	// Klientet mund te preferojne nje ose disa restorante dhe nje restorant mund te
	// zgjidhet nga nje ose N-kliente
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "restorant_users", joinColumns = {
			@JoinColumn(name = "userId", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "idRest", referencedColumnName = "idRestorant") })
	@JsonIgnoreProperties
	private List<Restorant> rest = new ArrayList<Restorant>();

	// Admini menaxhon dishes
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Dish> dishes = new ArrayList<Dish>();

	// Klienti shton ne shporte disa menu duke selektuar edhe numrin e artikujve per
	// cdo menu
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<AddInBasket> addInBaskets = new ArrayList<AddInBasket>();

	// Klienti mund te kryeje nje ose disa porosi ne nje interval te shkurter kohe
	// ose gjate te gjithe intervalit ditor
	@OneToMany(mappedBy = "User", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Order> orders = new ArrayList<Order>();

	// Klienti mund te kryeje disa rezervime gjate intervalit kohor ditor
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CustomerReservation> customerReservations = new ArrayList<CustomerReservation>();

	// Nje shippers-i i urdherohet te dergoje disa shporta porosie
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PackageOrdered> package_Orders = new ArrayList<PackageOrdered>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "first_name")
	private String first_name;
	@Column(name = "last_name")
	private String last_name;
	@Column(name = "address")
	private String address;
	@Column(name = "phoneNo")
	private String phoneNo;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "personalIdentityNo")
	private String personalIdentityNo;
	@Enumerated(EnumType.STRING)
	private ShippersStatus shippersStatus;
	@Column(name = "age")
	private Integer age;
	@Enumerated(EnumType.STRING)
	private UserRole userRole;

	public User() {
		super();
	}

	public User(String first_name, String last_name, String address, String phoneNo, String email, String password,
			String personalIdentityNo, ShippersStatus shippersStatus, Integer age, UserRole userRole,
			List<CustomerReservation> customerReservations, List<PackageOrdered> package_Orders, List<Order> orders,
			List<AddInBasket> addInBaskets, List<Dish> dishes, List<Restorant> rest, User shippers, List<User> user,
			List<CardBank> cardBank, List<DishCategory> dishCategories, Restorant restorant, List<Order> orders1,
			User adminPlatforma, WebAplication webAplication) {
		super();

		this.setFirst_name(first_name);
		this.setLast_name(last_name);
		this.setAddress(address);
		this.setPhoneNo(phoneNo);
		this.setEmail(email);
		this.setPassword(password);
		this.personalIdentityNo = personalIdentityNo;
		this.setShippersStatus(shippersStatus);
		this.setAge(age);
		this.setUserRole(userRole);
		this.cardBank = cardBank;
		this.dishCategories = dishCategories;
		this.setRest(rest);
		this.setShippers(shippers);
		this.setDishes(dishes);
		this.setAddInBaskets(addInBaskets);
		this.setOrders(orders);
		this.setCustomerReservations(customerReservations);
		this.setPackage_Orders(package_Orders);
		this.setRestorant(restorant);
		this.setOrders1(orders1);
	}

	@Override
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

	public String getPersonalIdentityNo() {
		return personalIdentityNo;
	}

	public void setPersonalIdentityNo(String personalIdentityNo) {
		this.personalIdentityNo = personalIdentityNo;
	}

	public ShippersStatus getShippersStatus() {
		return shippersStatus;
	}

	public void setShippersStatus(ShippersStatus shippersStatus) {
		this.shippersStatus = shippersStatus;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole2) {
		this.userRole = userRole2;
	}

	public List<CardBank> getCardBank() {
		return cardBank;
	}

	public void setCards(List<CardBank> cardBank) {
		this.cardBank = cardBank;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public User getShippers() {
		return shippers;
	}

	public void setShippers(User user2) {
		this.shippers = user2;
	}

	public List<Restorant> getRest() {
		return rest;
	}

	public void setRest(List<Restorant> rest) {
		this.rest = rest;
	}

	public List<DishCategory> getDishCategories() {
		return dishCategories;
	}

	public void setDishCategories(List<DishCategory> dishCategories) {
		this.dishCategories = dishCategories;
	}

	public List<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}

	public List<AddInBasket> getAddInBaskets() {
		return addInBaskets;
	}

	public void setAddInBaskets(List<AddInBasket> addInBaskets) {
		this.addInBaskets = addInBaskets;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<CustomerReservation> getCustomerReservations() {
		return customerReservations;
	}

	public void setCustomerReservations(List<CustomerReservation> customerReservations) {
		this.customerReservations = customerReservations;
	}

	public List<PackageOrdered> getPackage_Orders() {
		return package_Orders;
	}

	public void setPackage_Orders(List<PackageOrdered> package_Orders) {
		this.package_Orders = package_Orders;
	}

	public Restorant getRestorant() {
		return restorant;
	}

	public void setRestorant(Restorant restorant) {
		this.restorant = restorant;
	}

	public List<Order> getOrders1() {
		return orders1;
	}

	public void setOrders1(List<Order> orders1) {
		this.orders1 = orders1;
	}

	public User getAdminPlatforma() {
		return AdminPlatforma;
	}

	public void setAdminPlatforma(User adminPlatforma) {
		AdminPlatforma = adminPlatforma;
	}

	public WebAplication getWebAplication() {
		return webAplication;
	}

	public void setWebAplication(WebAplication webAplication) {
		this.webAplication = webAplication;
	}

	public String toString() {
		return "User[id = " + id + ",first_name = " + first_name + ",last_name = " + last_name + ",address = " + address
				+ ",phoneNo = " + address + ",email = " + email + ",password = " + password + ",personalIdentityNo = "
				+ personalIdentityNo + ",shippersStatus = " + shippersStatus + ",age = " + age + ",userRole = "
				+ userRole + ",dishCategories = " + dishCategories + ",cardBank = " + cardBank + ",user = " + user
				+ ",shippers = " + shippers + ",rest = " + rest + ",dishes = " + dishes + ",addInBaskets = "
				+ addInBaskets + ",orders = " + orders + ", customerReservations = " + customerReservations
				+ ", package_Orders = " + package_Orders + ",restorant = " + restorant + ",orders1 = " + orders1
				+ ",adminPlatforma = " + AdminPlatforma + ",webAplication = " + webAplication + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return Arrays.stream(userRole.name().split(",")).map(SimpleGrantedAuthority::new).toList();
	}

	@Override
	public String getUsername() {
		return email;
	}

	public void setUsername(String username) {
		this.email = username;
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}
