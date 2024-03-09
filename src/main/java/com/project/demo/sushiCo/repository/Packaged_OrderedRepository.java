package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.sushiCo.entity.Package_Ordered;
@Repository
public interface Packaged_OrderedRepository extends JpaRepository<Package_Ordered, Integer> {

}
