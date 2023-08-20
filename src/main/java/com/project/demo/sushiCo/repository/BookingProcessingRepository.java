package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.project.demo.sushiCo.domain.dto.BookingProcessingDto;
import com.project.demo.sushiCo.domain.dto.RegisterBookingFormDto;
import com.project.demo.sushiCo.entity.BookingProcessing;
import com.project.demo.sushiCo.service.RegisterBookingForm;
import jakarta.validation.Valid;

@Service
public interface BookingProcessingRepository extends JpaRepository<BookingProcessing, Integer> {

	@Query("Select c.id ,cr.cR_Id ,r.idRestorant "
			+ "From BookingProcessing  bp INNER JOIN User c ON c.bp.customerId = c.id  "
			+ " INNER JOIN RestorantTable rt ON rt.bp.reservationId =rt.rtb_id "
			+ " Where c.id =: ?1 and cr.cR_Id =: ?2  and rt.rtb_id IN "
			+ "(Select r.idRestorant From rt Inner Join Restorant r ON rt.rtb_id = rt.r.restorant_tbId Where r.idRestorant =: idRestorant)")
	RegisterBookingForm getCustomerReservationById(Integer id, Integer cR_Id, Integer idRestorant);

	BookingProcessing save(RegisterBookingFormDto reservation);

	@Query("Insert into BookingProcessing(reservationDate,start_reservationTime,end_reservationTime,noParticipants,reservationDescription,customerId,reservationId)"
			+ " Values(?1,?2,?3,?4,?5,(Select c.id,concat(c.First_name,'',c.Last_name) as customerName,c.phoneNo From User c inner join BookingProcessing bp ON c.id = c.bp.customerId Where c.id =: id ),"
			+ "(Select rt.tableName,rt.availableTables,rt.lockedTables,bp.reservationId From BookingProcessing bp Inner Join RestorantTables rt ON rt.bp.reservationId = rt.rtb_id )"
			+ "Where rt.bp.reservationId =: reservationId AND rt IN (Update RestorantTables rt Set rt.lockedTables =:lockedTables"
			+ "Where rt.availableTables = (rt.noTables - rt.lockedTables)")
	RegisterBookingForm createBooking(@Valid BookingProcessingDto cReservation);

	@Modifying
	@Query("UPDATE BookingProcessing bp"
			+ "SET bp.reservationDate =: ?1 And bp.start_reservationTime =: ?2  And bp.end_reservationTime =: ?3 And bp.noParticipants =: ?4 And bp.reservationDescription =:?5"
			+ "Where Exists (Select rtb.tableName,rtb.lockedTables  From  BookingProcessing bp INNER JOIN User c ON c.bp.customerId = c.id "
			+ "INNER JOIN RestorantTables rtb ON rtb.bp.reservationId = rtb.rtb_id"
			+ "Where c.id =: ?1 And bp.cR_Id =: ?2 And rtb.rtb_id IN (Update rtb Set rtb.tableName and rtb.lockedTables"
			+ "Where rtb.rtb_id  IN (Select r.idRestorant =: ?1  From rtb Inner Join Restorant r ON rtb.rtb_id = rtb.r.idRestorant Where rtb.rtb_id =: ?1 and rtb.r.idRestorant =: ?2  )")

	RegisterBookingForm update(@Valid BookingProcessingDto reservation, Integer id, Integer rtb_id);

	@Modifying
	@Query("Delete From BookingProcessing  bp Inner join User c ON c.bp.customerId = c.id"
			+ "Inner Join  RestorantTables tb ON tb.bp.restorant_tbId = tb.rtb_id "
			+ "Where tb.rtb_id IN (Select r.idRestorant =: ?1  From rtb Inner Join Restorant r ON tb.rtb_id = tb.r.idRestorant Where tb.rtb_id =: ?1 and tb.r.idRestorant =: ?2 )")
	void deleteReservation(Integer id, Integer cR_id);

}