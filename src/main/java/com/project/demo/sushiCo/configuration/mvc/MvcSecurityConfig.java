package com.project.demo.sushiCo.configuration.mvc;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.project.demo.sushiCo.configuration.SecurityUserDetailsService;
import com.project.demo.sushiCo.entity.UserRole;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;


@Profile("mvc")
@RequiredArgsConstructor
@Configuration
public class MvcSecurityConfig {

	@PostConstruct
    public void init(){
        System.err.println("Security Profile Basic");
    }

	private SecurityUserDetailsService securityUserDetailsService;
	private OnLoginSuccessHandler loginSuccessHandler;
	private OnLogoutSuccessHandler logoutSuccessHandler;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers("/ ").permitAll()
				.requestMatchers("/register").permitAll()
						.requestMatchers("/api/admin/**").hasAuthority(UserRole.ADMIN.name())
						.requestMatchers("/api/customer/**").hasAuthority(UserRole.CUSTOMER.name())
						.requestMatchers("/api/shippers/**").hasAuthority(UserRole.SHIPPERS.name())
						.requestMatchers("/api/administrator/**").hasAuthority(UserRole.ADMINISTRATOR.name()).anyRequest()
						.authenticated())
				.userDetailsService(securityUserDetailsService)
				.httpBasic(Customizer.withDefaults())
				.formLogin(form -> form.loginPage("/login").permitAll().successHandler((AuthenticationSuccessHandler) loginSuccessHandler))
				.logout((logout) -> logout.permitAll().logoutSuccessHandler(logoutSuccessHandler)).build();
	}
}
