package com.project.demo.sushiCo.configuration.mvc;

import java.io.IOException;

import org.springframework.security.core.Authentication;

import jakarta.servlet.ServletException;

public interface AuthentificationSuccessHandler {
	public void onAuthenticationSuccess(javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException;

}
