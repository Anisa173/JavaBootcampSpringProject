package com.project.demo.sushiCo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.project.demo.sushiCo.domain.dto.RegisterBookingFormDto;
import com.project.demo.sushiCo.domain.dto.BookingProcessingDto;
import com.project.demo.sushiCo.domain.mappers.BookingProcessingMapper;
import com.project.demo.sushiCo.domain.mappers.RegisterBookingFormMapper;
import com.project.demo.sushiCo.repository.BookingProcessingRepository;
import com.project.demo.sushiCo.service.BookingProcessingService;
import com.project.demo.sushiCo.service.RegisterBookingForm;

import jakarta.validation.Valid;

@Validated
@Service
public class BookingProcessingServiceImpl implements BookingProcessingService {

	@Autowired
	private final BookingProcessingRepository bookingRepository;
	private final BookingProcessingMapper bookingMapper;
	private final RegisterBookingFormMapper registerBookMapper;

	public BookingProcessingServiceImpl(BookingProcessingRepository bookingRepository,
			BookingProcessingMapper bookingMapper, RegisterBookingFormMapper registerBookMapper) {
		this.bookingRepository = bookingRepository;
		this.bookingMapper = bookingMapper;
		this.registerBookMapper = registerBookMapper;
	}

	@Override
	public BookingProcessingDto register(@Valid RegisterBookingForm bookingForm, Integer idCustomer) throws Exception {

		var reservation = getCustomerReservationById(bookingForm.getId(), bookingForm.getIdCustomer(),
				bookingForm.getRtb_id());
		reservation.setFirst_name(bookingForm.getFirst_name());
		reservation.setLast_name(bookingForm.getLast_name());
		reservation.setPhoneNo(bookingForm.getPhoneNo());
		reservation.setReservationDate(bookingForm.getReservationDate());
		reservation.setStart_reservationTime(bookingForm.getStart_reservationTime());
		reservation.setEnd_reservationTime(bookingForm.getEnd_reservationTime());
		reservation.setNoParticipants(bookingForm.getNoParticipants());
		reservation.setReservationDescription(bookingForm.getReservationDescription());
		reservation.setTables(bookingForm.getTables());
		
		return bookingMapper.toDto(bookingRepository.save(reservation));
	}

	@Override
	public RegisterBookingFormDto getCustomerReservationById(Integer idCustomer, Integer cR_Id, Integer rtb_id)
			throws Exception {
		return registerBookMapper.toDto(bookingRepository.getCustomerReservationById(idCustomer, cR_Id, rtb_id));
	}

	@Override
	public RegisterBookingFormDto createBooking(@Valid RegisterBookingFormDto regBooking) throws Exception {

		return registerBookMapper.toDto(bookingRepository.createBooking(regBooking));
	}


	@Override
	public void deleteReservation(Integer id, Integer cR_id,Integer idRestorant) throws Exception {
		bookingRepository.deleteReservation(id, cR_id,idRestorant);

	}



	@Override
	public RegisterBookingFormDto update(@Valid RegisterBookingFormDto regBooking,
			@Valid RegisterBookingFormDto customerReservationById) throws Exception {
	
		return registerBookMapper.toDto(bookingRepository.update(regBooking));
	}




}
