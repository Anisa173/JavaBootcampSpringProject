package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.domain.dto.RegisterBookingFormDto;
import com.project.demo.sushiCo.domain.dto.BookingProcessingDto;

import jakarta.validation.Valid;

public interface BookingProcessingService {

	BookingProcessingDto register(@Valid RegisterBookingForm bookingForm) throws Exception;

	public RegisterBookingFormDto getCustomerReservationById(Integer idCustomer, Integer cR_Id, Integer idRestorant)
			throws Exception;

	public RegisterBookingFormDto createBooking(@Valid BookingProcessingDto cReservation) throws Exception;

	public RegisterBookingFormDto update(@Valid BookingProcessingDto reservation, Integer id, Integer rtb_id)
			throws Exception;

	public void deleteReservation(Integer id, Integer cR_id) throws Exception;

	
}
