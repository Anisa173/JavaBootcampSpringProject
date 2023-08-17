package com.project.demo.sushiCo.domain.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.project.demo.sushiCo.domain.dto.BookingProcessingDto;
import com.project.demo.sushiCo.entity.BookingProcessing;

@Component
public class BookingProcessingMapper extends BaseMapper<BookingProcessing, BookingProcessingDto> {

	@Override
	public BookingProcessing toEntity(BookingProcessingDto dto) {
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
	public BookingProcessingDto toDto(BookingProcessing entity) {
		BookingProcessingDto reservationDto = new BookingProcessingDto();
		reservationDto.setcR_Id(entity.getId());
		reservationDto.setReservationDate(entity.getReservationDate());
		reservationDto.setStart_reservationTime(entity.getStart_reservationTime());
		reservationDto.setEnd_reservationTime(entity.getEnd_reservationTime());
		reservationDto.setNoParticipants(entity.getNoParticipants());
		reservationDto.setReservationDescription(entity.getReservationDescription());
		reservationDto.setCustomerId(entity.getUser().getId());
		var customerName = entity.getUser().getFirst_name().concat(" ").concat(entity.getUser().getLast_name());
		reservationDto.setCustomerName(customerName);
		reservationDto.setReservationId(entity.getTables().getId());
		var tableName = entity.getTables().getTableName();
		reservationDto.setTableName(tableName);
		return reservationDto;
	}

	@Override
	public BookingProcessing toUpdate(BookingProcessingDto dto, BookingProcessing entity) {
		entity.setReservationDate(dto.getReservationDate());
		entity.setStart_reservationTime(dto.getStart_reservationTime());
		entity.setEnd_reservationTime(dto.getEnd_reservationTime());
		entity.setNoParticipants(dto.getNoParticipants());
		entity.setReservationDescription(dto.getReservationDescription());
		return entity;
	}

	@Override
	public List<BookingProcessing> toEntity(List<BookingProcessingDto> dtoList) {
		if ( dtoList == null ) {
            return null;
        }

        List<BookingProcessing> list = new ArrayList<BookingProcessing>( dtoList.size() );
        for ( BookingProcessingDto bookPDto : dtoList ) {
            list.add( toEntity( bookPDto ) );
        }

        return list;
	}

	@Override
	public List<BookingProcessingDto> toDto(List<BookingProcessing> entityList) {
		 if ( entityList == null ) {
	            return null;
	        }

	        List<BookingProcessingDto> list = new ArrayList<BookingProcessingDto>( entityList.size() );
	        for ( BookingProcessing bookP : entityList ) {
	            list.add( toDto( bookP ) );
	        }

	        return list;
	}
}
