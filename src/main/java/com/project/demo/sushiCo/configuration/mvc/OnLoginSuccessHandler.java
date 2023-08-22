 package com.project.demo.sushiCo.configuration.mvc;

import java.io.IOException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import com.project.demo.sushiCo.entity.User;
import com.project.demo.sushiCo.entity.UserRole;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class OnLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private static final SimpleGrantedAuthority ADMIN_ROLE = new SimpleGrantedAuthority(UserRole.ADMIN.name());
	private static final SimpleGrantedAuthority CUSTOMER_ROLE = new SimpleGrantedAuthority(UserRole.CUSTOMER.name());
	private static final SimpleGrantedAuthority SHIPPERS_ROLE = new SimpleGrantedAuthority(UserRole.SHIPPERS.name());
	private static final SimpleGrantedAuthority ADMINISTRATOR_ROLE = new SimpleGrantedAuthority(UserRole.ADMINISTRATOR.name());
			

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		User userDetails = (User) authentication.getPrincipal();
		String redirectUrl = getRedirectUrl(userDetails, ((HttpServletRequest) request).getContextPath());
		((HttpServletResponse) response).sendRedirect(redirectUrl);

	}

	private String getRedirectUrl(User userDetails, String redirectUrl) {
		if (userDetails.getAuthorities().contains(ADMIN_ROLE)) {
			redirectUrl = (userDetails.getFirst_name() != null && userDetails.getLast_name() != null) ? "admin"
					: "users/details/" + userDetails.getId();
		} else if (userDetails.getAuthorities().contains(CUSTOMER_ROLE)) {
			System.err.println("User Details " + userDetails.getFirst_name());
			redirectUrl = (userDetails.getFirst_name() != null && userDetails.getLast_name() != null) ? "customer"
					: "users/details/" + userDetails.getId();
		} else if (userDetails.getAuthorities().contains(SHIPPERS_ROLE)) {
			System.err.println("User Details " + userDetails.getFirst_name());
			redirectUrl = (userDetails.getFirst_name() != null && userDetails.getLast_name() != null) ? "shippers"
					: "users/details/" + userDetails.getId();
		} else if (userDetails.getAuthorities().contains(ADMINISTRATOR_ROLE)) {
			System.err.println("User Details " + userDetails.getFirst_name());
			redirectUrl = (userDetails.getFirst_name() != null && userDetails.getLast_name() != null) ? "administrator"
					: "users/details/" + userDetails.getId();
		}

		return redirectUrl;
	}

}
