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

	@Query("Select c.id , bp.cR_Id , r.idRestorant "
			+ " From User c INNER JOIN  BookingProcessing  bp ON c.id = c.bp.customerId  "
			+ " INNER JOIN User adw  ON  adw.c.adminIdPlatforma = adw.id "
			+ " Where c.id =: ?1 and bp.cR_Id =: ?2  and adw.id  IN "
			+ "( Select r.idRestorant From Restorant r Inner Join User adw  ON  adw.r.adminIdWeb = adw.id )"
	+ " Inner Join RestorantTables tb ON tb.r.restorant_tbId = tb.rtb_id     Where r.idRestorant =: idRestorant")
	RegisterBookingForm getCustomerReservationById(Integer id, Integer cR_Id, Integer rtb_id);

	BookingProcessing save(RegisterBookingFormDto reservation);

	@Modifying
	@Query("Insert into BookingProcessing(reservationDate,start_reservationTime,end_reservationTime,noParticipants,reservationDescription,customerId,reservationId)"
			+ " Values(?1,?2,?3,?4,?5,(Select c.id,concat(c.First_name,'',c.Last_name)  customerName,c.phoneNo From User c inner join BookingProcessing bp ON c.id = c.bp.customerId Where c.id =: id ),"
			+ "( Select rt.tableName,rt.availableTables,rt.lockedTables,bp.reservationId  From BookingProcessing bp Inner Join RestorantTables rt ON rt.bp.reservationId = rt.rtb_id )"
			+ " Where rt.bp.reservationId =: reservationId  AND rt IN (Update RestorantTables rt Set rt.lockedTables =:lockedTables"
			+ " Where rt.availableTables =: (rt.noTables - rt.lockedTables)")
RegisterBookingForm createBooking(@Valid RegisterBookingFormDto regBooking);

	@Modifying
	@Query(" UPDATE BookingProcessing bp "
			+ "  SET bp.reservationDate =: ?1 And bp.start_reservationTime =: ?2  And bp.end_reservationTime =: ?3 And bp.noParticipants =: ?4 And bp.reservationDescription =: ?5 "
			+ "  Where Exists ( Select rtb.tableName , rtb.lockedTables  From  BookingProcessing bp INNER JOIN User c ON c.bp.customerId = c.id  "
			+ "  INNER JOIN RestorantTables rtb ON rtb.bp.reservationId = rtb.rtb_id "
			+ "  Where c.id =: ?1 And bp.cR_Id =: ?2 And rtb.rtb_id IN ( Update rtb Set rtb.tableName =: tableName and rtb.lockedTables =: lockedTables "
			+ "  Where rtb.rtb_id =: rtb_id )))")

	RegisterBookingForm update(@Valid RegisterBookingFormDto regBooking);

	@Modifying
	@Query(" Delete From BookingProcessing  bp Inner Join User c ON c.bp.customerId = c.id "
			+ " Inner Join  RestorantTables tb ON tb.bp.restorant_tbId = tb.rtb_id  "
			+ " Where c.bp.cR_id =: ?1 And c.id =: ?2  And tb.rtb_id IN (Select r.idRestorant  From rtb Inner Join Restorant r ON tb.rtb_id = tb.r.idRestorant Where tb.r.idRestorant =: ?2 )")
	void deleteReservation(Integer id, Integer cR_id,Integer idRestorant);

	

	

}