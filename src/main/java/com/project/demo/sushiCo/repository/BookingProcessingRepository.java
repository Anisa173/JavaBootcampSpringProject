package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.project.demo.sushiCo.domain.dto.RegisterBookingFormDto;
import com.project.demo.sushiCo.entity.BookingProcessing;
import com.project.demo.sushiCo.service.RegisterBookingForm;
import jakarta.validation.Valid;

@Service
public interface BookingProcessingRepository extends JpaRepository<BookingProcessing, Integer> {

	//Klienti sheh rezervimet qe ka kryer ne profilin e tij
	@Query("Select c.id , bp.cR_Id , r.idRestorant  "
			+ "  From BookingProcessing  bp INNER JOIN  User c ON  c.bp.customerId = c.id  "
			+ "  INNER JOIN RestorantTables rt  ON rt.bp.restorant_tbId = rt.rtb_id  "
			+ "  Where c.id =: ?1 and bp.cR_Id =: ?2  and rt.rtb_id  IN  "
			+ " ( Select tb.rtb_id From User adw  Inner Join Restorant r  ON   adw.id = adw.r.adminIdWeb ) "
	        + " Inner Join RestorantTables tb ON tb.r.restorant_tbId =: tb.rtb_id  Where r.idRestorant =: idRestorant ")
	RegisterBookingForm getCustomerReservationById(Integer id, Integer cR_Id, Integer rtb_id);

	BookingProcessing save(RegisterBookingFormDto reservation);

	@Modifying
	@Query("Insert into BookingProcessing(reservationDate,start_reservationTime,end_reservationTime,noParticipants,reservationDescription,customerId,reservationId)"
			+ " Values(?1,?2,?3,?4,?5,(Select c.id From User c inner join BookingProcessing bp ON c.id = c.bp.customerId Where c.id =: id and fullName = concat(c.First_name,' ',c.Last_name) and c.phoneNo=:phoneNo ),"
			+ "( Select bp.reservationId  From BookingProcessing bp Inner Join RestorantTables rt ON rt.bp.reservationId = rt.rtb_id "
			+ " Where bp.reservationId = :reservationId  AND Exists (Select rtbl.rtb_id From RestorantTables rtbl Where rtbl.lockedTables =:lockedTables"
			+ " And rtbl.availableTables =: (rtbl.noTables - rtbl.lockedTables ) And rt.rtb_id = rtbl.rtb_id")
    RegisterBookingForm createBooking(@Valid RegisterBookingFormDto regBooking);

	@Modifying
	@Query(" UPDATE bp "
			+ " SET bp.reservationDate =:?1,bp.start_reservationTime =:?2, bp.end_reservationTime =:?3,bp.noParticipants =: ?4,bp.reservationDescription =: ?5 ,bp.tables.tableName=:?6,"
            + " bp.tables.availableTables=:?7,bp.tables.lockedTables=:?8 , bp.user.First_name=:?9,bp.user.Last_name=:?10,bp.user.phoneNo=:?11 "
			+ " FROM BookingProcessing bp  INNER JOIN User c ON c.bp.customerId = c.id  "
			+ "                            INNER JOIN RestorantTables rtb ON rtb.bp.reservationId = rtb.rtb_id "
			+ "  Where c.id =: ?1 And bp.cR_Id =: ?2 And + Where rtb.rtb_id =: rtb_id )))")
	RegisterBookingForm update(@Valid RegisterBookingFormDto regBooking,
			@Valid RegisterBookingForm customerReservation);

	@Modifying
	@Query(" Delete From BookingProcessing bp Inner Join User c ON c.bp.customerId = c.id "
			+ " Inner Join  RestorantTables tbl ON tbl.bp.restorant_tbId = tbl.rtb_id  "
			+ " Where bp.cR_id = :?1 And c.id =: ?2  And tbl.rtb_id IN (Select tb.rtb_id  "
            + " From RestorantTables tb Inner Join Restorant r ON tb.rtb_id = tb.r.idRestorant Where tb.r.idRestorant =:idRestorant )")
	void deleteReservation(Integer id, Integer cR_id,Integer idRestorant);

	@Query("Select c.id , bp , r.restName  "
			+ "  From BookingProcessing  bp INNER JOIN  User c ON  c.bp.customerId = c.id  "
			+ "  INNER JOIN RestorantTables rt  ON rt.bp.restorant_tbId = rt.rtb_id  "
			+ "  Where c.id =:?1 and bp.cR_Id =:?2  and rt.rtb_id  IN  "
			+ " ( Select tb.rtb_id From Restorant r Inner Join User adw  ON  adw.r.adminIdWeb = adw.id ) "
	        + "  Inner Join RestorantTables tb ON tb.r.restorant_tbId = tb.rtb_id "
	        + "  Group By r.restName "  
	        + "  Order By  bp.cR_Id  ")
	RegisterBookingForm getAllCustomerReservation(Integer id, Integer cR_Id);

	

	

}