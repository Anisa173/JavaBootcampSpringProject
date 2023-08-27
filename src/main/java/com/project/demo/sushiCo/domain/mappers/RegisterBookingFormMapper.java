package com.project.demo.sushiCo.domain.mappers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.project.demo.sushiCo.domain.dto.RegisterBookingFormDto;
import com.project.demo.sushiCo.service.RegisterBookingForm;

@Component
public class RegisterBookingFormMapper extends BaseMapper<RegisterBookingForm,RegisterBookingFormDto> {

	@Override
	public RegisterBookingForm toEntity(RegisterBookingFormDto dto) {
		var regB = new RegisterBookingForm();
	regB.setCrId(dto.getCrId());
	regB.setFirst_name(dto.getFirst_name());	
	regB.setLast_name(dto.getLast_name());
	regB.setPhoneNo(dto.getPhoneNo());
	regB.setReservationDate(dto.getReservationDate());
	regB.setStart_reservationTime(dto.getStart_reservationTime());
	regB.setEnd_reservationTime(dto.getEnd_reservationTime());
	regB.setNoParticipants(dto.getNoParticipants());
	regB.setReservationDescription(dto.getReservationDescription());
	regB.setTables(dto.getTables());
	regB.setIdCustomer(dto.getIdCustomer());
	regB.setRtb_id(dto.getRtb_id());
	return regB;
	}

	@Override
	public RegisterBookingFormDto toDto(RegisterBookingForm entity) {
		var regB = new RegisterBookingFormDto();
		regB.setCrId(entity.getId());
		regB.setFirst_name(entity.getFirst_name());	
		regB.setLast_name(entity.getLast_name());
		regB.setPhoneNo(entity.getPhoneNo());
		regB.setReservationDate(entity.getReservationDate());
		regB.setStart_reservationTime(entity.getStart_reservationTime());
		regB.setEnd_reservationTime(entity.getEnd_reservationTime());
		regB.setNoParticipants(entity.getNoParticipants());
		regB.setReservationDescription(entity.getReservationDescription());
		regB.setTables(entity.getTables());
		regB.setIdCustomer(entity.getIdCustomer());
		regB.setRtb_id(entity.getRtb_id());
		return regB;
	}

	@Override
	public RegisterBookingForm toUpdate(RegisterBookingFormDto entity, RegisterBookingForm regB ) {
		regB.setReservationDate(entity.getReservationDate());
		regB.setStart_reservationTime(entity.getStart_reservationTime());
		regB.setEnd_reservationTime(entity.getEnd_reservationTime());
		regB.setNoParticipants(entity.getNoParticipants());
		regB.setReservationDescription(entity.getReservationDescription());
		regB.setTables(entity.getTables());
		return regB;
	}

	@Override
	public List<RegisterBookingForm> toEntity(List<RegisterBookingFormDto> dtoList) {
		if ( dtoList == null ) {
            return null;
        }

        List<RegisterBookingForm> list = new ArrayList<RegisterBookingForm>( dtoList.size() );
        for ( RegisterBookingFormDto regBDto : dtoList ) {
            list.add( toEntity( regBDto ) );
        }

        return list;
	}

	@Override
	public List<RegisterBookingFormDto> toDto(List<RegisterBookingForm> entityList) {
		 if ( entityList == null ) {
	            return null;
	        }

	        List<RegisterBookingFormDto> list = new ArrayList<RegisterBookingFormDto>( entityList.size() );
	        for ( RegisterBookingForm regB : entityList ) {
	            list.add( toDto( regB ) );
	        }

	        return list;
	}

}
