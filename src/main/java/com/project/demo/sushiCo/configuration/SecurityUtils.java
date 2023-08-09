package com.project.demo.sushiCo.configuration;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

import com.project.demo.sushiCo.entity.User;

public class SecurityUtils {
	public static String getAfterDetailsCompletedRedirectUrl() {
		User loggedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
		return switch (loggedUser.getUserRole()) {
		
		case CUSTOMER -> "/customer";
		case ADMIN -> "/admin";
		case SHIPPERS -> "/shippers";
		case ADMINISTRATOR -> "/administrator ";
		default -> throw new IllegalArgumentException("Unexpected value: " + loggedUser.getUserRole());
		};
	}

	public static Integer getLoggedUserId() {
		 var authentication = SecurityContextHolder.getContext().getAuthentication();
	        if((authentication != null) && (authentication.getPrincipal() instanceof User)){
	            //handle mvc profile
	            return getMvcLoggedUser();
	        }else if((authentication != null) && (authentication.getPrincipal() instanceof Jwt)){
	            // handle jwt profile
	            return getMvcLoggedUser();
	        }else {
	            //handle null authentication
	            return null;
	        }
	    
	}

	private static Integer getMvcLoggedUser() {
		   var authentication = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        return authentication.getId();
	    }









}
