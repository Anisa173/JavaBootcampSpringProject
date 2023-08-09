package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.demo.sushiCo.domain.dto.RestorantDto;
import com.project.demo.sushiCo.entity.Restorant;

public interface RestorantRepository extends JpaRepository<Restorant, Integer>{

	Restorant save(RestorantDto restorant);

}
