package com.project.demo.sushiCo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.sushiCo.domain.dto.UserDto;
import com.project.demo.sushiCo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByEmail(String email);

	User save(UserDto user);

	

}
