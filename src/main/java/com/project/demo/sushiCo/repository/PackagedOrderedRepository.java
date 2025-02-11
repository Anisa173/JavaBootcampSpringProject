package com.project.demo.sushiCo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.project.demo.sushiCo.domain.dto.TransportingPackageOrderFormDto;
import com.project.demo.sushiCo.entity.PackageOrdered;
import com.project.demo.sushiCo.service.TransportingPackageOrderForm;
import jakarta.validation.Valid;

@Service
public interface PackagedOrderedRepository extends JpaRepository<PackageOrdered, Integer> {

	@Query("Select shp.id, or.oId,sp.Id " + " From PackageOrdered po INNER JOIN User shp ON shp.po.shippersId = shp.id "
			+ " INNER JOIN Order or ON po.or.idShporta = po.id "
			+ " INNER JOIN ServicePlaces sp ON sp.po.serviceId = sp.Id "
			+ " Where shp.id =: ?1 AND sp.Id =: ?2 AND or.oId IN "
			+ " (Select o.oId  From Order o INNER JOIN User c ON c.o.idCustomer = c.id "
			+ " INNER JOIN User a ON a.o.adminRestId = a.id  Where c.id = :?1 And a.id = :?2 ) ")
	TransportingPackageOrderForm getPackageOrderById(Integer userId, Integer serviceId, Integer idShporta);

	PackageOrdered save(TransportingPackageOrderFormDto packOrdert);

	@Query(" Insert into PackageOrdered(statusOrderSession,sessionPayment,shippersId,serviceId) "
			+ " Values('IN_PROGRESS',?1,( Select ship.id"
			+ " From User ship INNER JOIN PackageOrdered pckg ON ship.pckg.shippersId = ship.id "
			+ "                INNER JOIN User a ON  a.ship.idAdmin = a.id "
			+ " Where ship.id =: id  And pckg.id =: id  And a.id =: id),"
			+ "( Select sp.Id From PackageOrdered pckg INNER JOIN ServicePlaces sp ON sp.pckg.serviceId = sp.Id Where sp.id =: ?1 And pckg.id =: ?2 )) "
			+ " Select pckg.sessionPayment From Order o INNER JOIN PackageOrdered pckg ON pckg.o.idShporta = pckg.id "
			+ " INNER JOIN User c ON c.o.idCustomer = c.id  Where c.id =: id And pckg.id IN "
			+ " (Select pkg.id  From PackageOrdered pkg INNER JOIN Order o ON pkg.id = pkg.o.idShporta )"
			+ " INNER JOIN ServicePlaces sp ON  sp.pkg.serviceId = sp.Id"
			+ " Where  pkg.sessionPayment =: (sum(o.orderPrize) + sp.shippingCost) ")
	TransportingPackageOrderForm create(@Valid TransportingPackageOrderFormDto shippingPackOrder);

//customer
	@Modifying
	@Query(" Update pck Set pck.statusOrderSession =: 'PROCESSED' From PackageOrdered pck Where  pck.id IN "
			+ " ( Select pkg.id From PackageOrdered pkg INNER JOIN Order o ON pkg.id = pkg.o.idShporta "
			+ " INNER JOIN User shp ON shp.pkg.shippersId = shp.id  "
			+ " INNER JOIN ServicePlaces sp ON sp.pkg.serviceId = sp.Id "
			+ " Where pkg.Id = :id And sp.Id = :Id And shp.id IN(  "
		    + " Select  sh.id From User sh Where sh.userStatus = 'ARRIVED' and sh.id = :id) "
			+ " And o.oId IN(Select o.oId From Order o INNER JOIN User c ON c.o.idCustomer = c.id  Where  c.id= :id) "
			+ " And o.oId  IN (Select o.oId From Order o Where o.orderStatus = 'PROCESSED' and o.oId =: oId)")
	TransportingPackageOrderForm updateByStatus(@Valid TransportingPackageOrderFormDto packOrderedDto,
			@Valid TransportingPackageOrderForm shippingPackOrder2, Integer id, Integer serviceId, Integer oId,
			Integer userId);

//Admini
	@Modifying
	@Query("Update PackageOrdered pck Set pck.statusOrderSession =: 'IN_PROGRESS' Where  pck.id IN "
			+ "	( Select pkg.id	 From PackageOrdered pkg INNER JOIN Order o ON pkg.id = pkg.o.idShporta "
			+ "	 INNER JOIN User t ON t.pkg.shippersId = t.id   INNER JOIN ServicePlaces sp ON sp.pkg.serviceId = sp.Id "
			+ "	 Where pkg.Id = :id And t.id IN(Select tr.id From User tr Where tr.userStatus = 'IN_TRANSIT' And tr.id = :id)"
			+ "  And  sp.Id= :Id  And  o.oId IN( Select o.oId  From  Order o INNER JOIN User c ON c.o.idCustomer = c.id "
			+ "	 Where o.orderStatus = 'IN_PROGRESS'  and o.oId =: oId  and  c.id IN ("
			+ "	 Select cust.id From User cust Where cust.userStatus = 'WAITING' And customerName_Surname = concat(cust.First_name,' ',cust.Last_name)"
            + "   And cust.address =:address  And cust.phoneNo =:phoneNo And cust.id =: id ) )")
	TransportingPackageOrderForm update(@Valid TransportingPackageOrderFormDto packOrDto,
			@Valid TransportingPackageOrderForm shippingPackOrder, Integer idShporta,
			Integer serviceId, Integer oId, Integer userId);

//Admini
	@Modifying
	@Query(" Update pcO Set deleted =: true , pcO.statusOrderSession =: ' Cancel '  From PackageOrdered pcO "
			+ " Where pcO.id IN ( Select pcO.id From Order o INNER JOIN pcO ON pcO.o.idShporta = pcO.id "
			+ " INNER JOIN User c ON  c.o.idCustomer = c.id "
			+ " INNER JOIN User a ON  a.o.adminRestId = a.id  Where  pcO.id =: ?1 And a.id =: ?2  And o.oId IN  "
			+ " (Select o.oId From Order o Where o.status = 'Cancel' And o.oId = :oId  )")
	void delete(Integer id, Integer oId, Integer adminRestId);

	@Query("  Select o.orderPrize , o.orderItems noItems , o.orderStatus, pack.id  noPackage , pack.sessionPayment Total_Cost  "
			+ " From PackageOrdered pack INNER JOIN Order o ON pack.o.idShporta = pack.id  "
			+ " INNER JOIN User sh ON sh.pack.shippersId = sh.id  Where  sh.id =:id And o.oId  "
			+ " IN( Select o.oId From o INNER JOIN User a ON a.o.adminRestId = a.id "   
		    + " INNER JOIN User c ON c.o.idCustomer = c.id  Where a.id =: id and c.id =: id ) ")
	List<TransportingPackageOrderForm> getAllPackageOByCustomerId(Integer userId);

	@Query(" Select o.orderPrize,o.orderItems noItems , o.orderStatus, pack.id  noPackage , pack.sessionPayment Total_Cost  "
			+ "	 From PackageOrdered pack INNER JOIN Order o IN pack.o.idShporta = pack.id  "
			+ "	 INNER JOIN User sh ON sh.pack.shippersId = sh.id  Where  sh.id =:id And o.oId  "
			+ "	 IN( Select o.oId From Order o INNER JOIN User a ON a.o.adminRestId = a.id " 
			+ "                          INNER JOIN User c ON c.o.idCustomer = c.id   Where a.id =: id  Group By c.id)")
	List<TransportingPackageOrderForm> getAllPackageOByshipperId(Integer userId);

	@Query(" Select o.orderPrize,o.orderItems noItems , o.orderStatus, pack.id  noPackage , pack.sessionPayment Total_Cost ,sp.servicePl Service_Places   "
			+ " From PackageOrdered pc INNER JOIN Order o ON pc.id = pc.o.idShporta "
			+ "                        INNER JOIN User sh ON  sh.pc.shippersId = sh.id "
			+ "                        INNER JOIN ServicePlaces sp ON sp.pc.serviceId = sp.Id " + "	Where sp.Id =: Id And o.oId IN  "
			+ "( Select o.oId From Order o INNER JOIN User c ON o.oId = o.c.idCustomer  Group By c.id ")
	List<TransportingPackageOrderForm> getPackageOrdersByServiceP(Integer Id);

	

}
