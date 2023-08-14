package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.domain.dto.BookingDto;
import com.project.demo.sushiCo.domain.dto.CustomerReservationDto;

import jakarta.validation.Valid;

public interface BookingProcessingService {

public BookingDto register(@Valid RegisterBookingForm bookingForm,Integer id,Integer cR_Id,Integer idRestorant) throws Exception;
	
public CustomerReservationDto getCustomerReservationById(Integer id,Integer cR_Id,Integer idRestorant) throws Exception;

public BookingDto createBooking(@Valid CustomerReservationDto cReservation ) throws Exception;

public BookingDto update(@Valid CustomerReservationDto reservation,Integer id,Integer idRestorant) throws Exception;

public void deleteReservation(Integer id,Integer idRestorant) throws Exception;

}
