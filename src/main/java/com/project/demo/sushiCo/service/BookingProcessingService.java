package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.domain.dto.RegisterBookingFormDto;
import com.project.demo.sushiCo.domain.dto.BookingProcessingDto;

import jakarta.validation.Valid;

public interface BookingProcessingService {

    public	BookingProcessingDto register(@Valid RegisterBookingForm bookingForm, Integer idCustomer) throws Exception;

	public RegisterBookingFormDto getCustomerReservationById(Integer idCustomer, Integer cR_Id, Integer idRestorant)
			throws Exception;

	public RegisterBookingFormDto getAllCustomerReservationById(Integer id, Integer cR_Id) throws Exception;

	public RegisterBookingFormDto createBooking(@Valid RegisterBookingFormDto regBooking) throws Exception;

	public void deleteReservation(Integer id, Integer cR_id, Integer idRestorant) throws Exception;

	public RegisterBookingFormDto update(@Valid RegisterBookingFormDto regBooking,@Valid RegisterBookingFormDto 
			customerReservationById) throws Exception;

}
