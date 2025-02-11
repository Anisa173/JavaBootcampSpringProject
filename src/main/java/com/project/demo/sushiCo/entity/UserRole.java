package com.project.demo.sushiCo.entity;

import java.util.Arrays;

public enum UserRole {

	CUSTOMER("Customer"), ADMIN("Admin"), SHIPPERS("Shippers"),ADMINISTRATOR("Administrator") ;

	private String value;

	UserRole() {
		
	}

	UserRole(String value) {
		this.value = value;
	}

	public static UserRole fromValue(UserRole userRole) {
		return Arrays.asList(UserRole.values()).stream().filter(e -> userRole.equals(e.value)).findFirst()
				.orElseThrow(() -> new RuntimeException(String.format("User's Role %s not found", userRole)));
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
}
//public static UserRole fromValue1(String role) {
//List<UseRole> userRole = Arrays.asList(UserRole.values());
//UserRole toReturnEnum = null;
//for(UserRole u : userRole) {
//	if(u.value.equals(role)) {
//		toReturnEnum = u;
//		break;
//	}
//else if(toReturnEnum==null) {
//	new RuntimeException(String
//			.format("User's Role not found",role));
//}
//
//}
//return toReturnEnum;
//
//}

