package com.project.demo.sushiCo.domain.mappers;

import org.springframework.stereotype.Component;

import com.project.demo.sushiCo.domain.dto.UserDto;
import com.project.demo.sushiCo.entity.ShippersStatus;
import com.project.demo.sushiCo.entity.User;
import com.project.demo.sushiCo.entity.UserRole;
import jakarta.validation.Valid;

@Component
public class UserMapper extends BaseMapper<User, UserDto> {

	@Override
	public User toEntity(UserDto user) {
		User user1 = new User();
		user1.setId(user.getId());
		user1.setFirst_name(user.getFirst_name());
		user1.setLast_name(user.getLast_name());
		user1.setAddress(user.getAddress());
		user1.setPhoneNo(user.getPhoneNo());
		user1.setEmail(user.getPhoneNo());
		user1.setPassword(user.getPassword());
		user1.setPersonalIdentityNo(user.getPersonalIdentityNo());
		user1.setAge(user.getAge());
		user1.setUserRole(UserRole.fromValue(user.getUserRole()));
		return user1;
	}

	@Override
	public UserDto toDto(User result) {
		UserDto userDto = new UserDto();
		userDto.setId(result.getId());
		userDto.setFirst_name(result.getFirst_name());
		userDto.setLast_name(result.getLast_name());
		userDto.setAddress(result.getAddress());
		userDto.setPhoneNo(result.getPhoneNo());
		userDto.setEmail(result.getPhoneNo());
		userDto.setPassword(result.getPassword());
		userDto.setPersonalIdentityNo(result.getPersonalIdentityNo());
		userDto.setShippersStatus(ShippersStatus.fromValue(result.getShippersStatus()));
		userDto.setAge(result.getAge());
		userDto.setUserRole(UserRole.fromValue(result.getUserRole()));
		var totalCardBank = result.getCardBank().stream().count();
		userDto.setTotalCardBank(totalCardBank);
		var totalShippers = result.getUser().stream().count();
		userDto.setTotalShippers(totalShippers);
		userDto.setIdAdmin(result.getShippers().getId());
		var totaldishCategories = result.getDishCategories().stream().count();
		userDto.setTotaldishCategories(totaldishCategories);
		var totalAppRests = result.getRest().stream().count();
		userDto.setTotalAppRests(totalAppRests);
		var totalDishes = result.getDishes().stream().count();
		userDto.setTotalDishes(totalDishes);
		var totalAddInBasket = result.getAddInBaskets().stream().count();
		userDto.setTotalAddInBaskets(totalAddInBasket);
		var totalOrders = result.getOrders().stream().count();
		userDto.setTotalOrders(totalOrders);
		var totalReservations = result.getCustomerReservations().stream().count();
		userDto.setTotalReservations(totalReservations);
		var totalPackage_Orders = result.getPackage_Orders().stream().count();
		userDto.setTotalPackage_Orders(totalPackage_Orders);
		userDto.setRestorant(result.getRestorant());
		var totalOrders1 = result.getOrders().stream().count();
		userDto.setTotalOrders1(totalOrders1);

		return userDto;
	}

	@Override
	public User toUpdate(@Valid UserDto dto, User entity) {
		entity.setLast_name(dto.getLast_name());
		entity.setAddress(dto.getAddress());
		entity.setPhoneNo(dto.getPhoneNo());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		entity.setPersonalIdentityNo(dto.getPersonalIdentityNo());
		
		return entity;
	}

}
