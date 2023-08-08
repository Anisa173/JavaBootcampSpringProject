package com.project.demo.sushiCo.configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.demo.sushiCo.repository.UserRepository;

public class SecurityUserDetailsService implements UserDetailsService{
private final UserRepository repository;

public SecurityUserDetailsService(UserRepository userRepository) {
			this.repository = userRepository;
		}

@Override
public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	return repository.findByEmail(email)
			.orElseThrow(() -> new UsernameNotFoundException("Email not found: " + email)) ;
}


	}


