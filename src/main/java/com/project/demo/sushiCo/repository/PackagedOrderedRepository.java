package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.PackageOrderedDto;
import com.project.demo.sushiCo.domain.dto.ShippingPackageOrderFormDto;
import com.project.demo.sushiCo.entity.PackageOrdered;
import com.project.demo.sushiCo.service.ShippingPackageOrderForm;

import jakarta.validation.Valid;

@Service
public interface PackagedOrderedRepository extends JpaRepository<PackageOrdered, Integer> {

@Query("Select shp.id, or.oId,sp.Id "	
+ " From PackageOrdered po INNER JOIN User shp ON shp.po.shippersId = shp.id "	
+ "INNER JOIN Order or ON po.or.idShporta = or.oId "	
+ "INNER JOIN ServicePlaces	sp ON sp.po.serviceId = sp.Id"
+  "Where shp.id =: ?1 AND sp.Id =: ?2 AND or.oId IN "                          
+ "(Select c.id , a.id  From Order o INNER JOIN User c ON c.o.idCustomer = c.id "
+  " INNER JOIN User a ON a.o.adminRestId = a.id" 
+ " Where c.id =: ?1 And a.id =: ?2 )")

ShippingPackageOrderForm getPackageOrderById(Integer adminRestId, Integer idCustomer, Integer shipperId,Integer serviceId,Integer idShporta);

PackageOrdered save(ShippingPackageOrderFormDto packOrdert);
@Query(" ")
ShippingPackageOrderForm create(@Valid PackageOrderedDto packOrderedDto);

}
