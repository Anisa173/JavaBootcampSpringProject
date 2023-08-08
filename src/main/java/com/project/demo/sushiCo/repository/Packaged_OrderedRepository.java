package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.sushiCo.entity.PackageOrdered;
@Repository
public interface Packaged_OrderedRepository extends JpaRepository<PackageOrdered, Integer> {

}
