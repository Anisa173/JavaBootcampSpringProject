package com.project.demo.sushiCo.domain.mappers;

import org.springframework.stereotype.Component;

import com.project.demo.sushiCo.domain.dto.CustomerReservationDto;
import com.project.demo.sushiCo.entity.BookingProcessing;
@Component
public class CustomerReservationMapper extends BaseMapper<BookingProcessing, CustomerReservationDto> {

	
	@Override
	public BookingProcessing toEntity(CustomerReservationDto dto) {
		BookingProcessing reservation = new BookingProcessing();
	reservation.setcR_Id(dto.getcR_Id());
	reservation.setReservationDate(dto.getReservationDate());
	reservation.setStart_reservationTime(dto.getStart_reservationTime());
	reservation.setEnd_reservationTime(dto.getEnd_reservationTime());
	reservation.setNoParticipants(dto.getNoParticipants());
	reservation.setReservationDescription(dto.getReservationDescription());
		return reservation;
	}

	@Override
	public CustomerReservationDto toDto(BookingProcessing entity) {
		CustomerReservationDto reservationDto = new CustomerReservationDto();
		reservationDto.setcR_Id(entity.getId());
		reservationDto.setReservationDate(entity.getReservationDate());
		reservationDto.setStart_reservationTime(entity.getStart_reservationTime());
		reservationDto.setEnd_reservationTime(entity.getEnd_reservationTime());
		reservationDto.setNoParticipants(entity.getNoParticipants());
		reservationDto.setReservationDescription(entity.getReservationDescription());
		reservationDto.setCustomerId(entity.getUser().getId());
		var customerName = entity.getUser().getFirst_name().concat(" ").concat(entity.getUser().getLast_name());
		reservationDto.setCustomerName(customerName);
		reservationDto.setTables(entity.getTables());
	
		return reservationDto;
	}

	@Override
	public BookingProcessing toUpdate(CustomerReservationDto dto, BookingProcessing entity) {
		entity.setReservationDate(dto.getReservationDate());
		entity.setStart_reservationTime(dto.getStart_reservationTime());
		entity.setEnd_reservationTime(dto.getEnd_reservationTime());
		entity.setNoParticipants(dto.getNoParticipants());
		entity.setReservationDescription(dto.getReservationDescription());	
		return entity;
	}

}
