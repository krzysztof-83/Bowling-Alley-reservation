package pl.christopherk.BowlingAlley.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.christopherk.BowlingAlley.common.dto.ReservationDto;
import pl.christopherk.BowlingAlley.common.exceptions.ReservationNotFoundException;
import pl.christopherk.BowlingAlley.persistance.domain.ReservationEntity;
import pl.christopherk.BowlingAlley.persistance.repository.ReservationRepository;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;
    private ModelMapper modelMapper;

    public ReservationService(ReservationRepository reservationRepository, ModelMapper modelMapper) {
        this.reservationRepository = reservationRepository;
        this.modelMapper = modelMapper;
    }

    public Set<ReservationDto> getAllReservations(){
        return StreamSupport.stream(reservationRepository.findAll().spliterator(), false)
                .map(this::convertToDto)
                .collect(Collectors.toSet());
    }

    public Set<ReservationDto> getReservationByTrackName(String trackName){
        return StreamSupport.stream(reservationRepository.findByTrackName(trackName).spliterator(), false)
                .map(this::convertToDto)
                .collect(Collectors.toSet());
    }

    public Set<ReservationDto> getReservationsCreatedByUser(String email){
        return StreamSupport.stream(reservationRepository.findByCreatedBy(email).spliterator(), false)
                .map(this::convertToDto)
                .collect(Collectors.toSet());
    }

    public Set<ReservationDto> getReservationsByDate(LocalDateTime date){
        return StreamSupport.stream(reservationRepository.findByReservationStart(date).spliterator(), false)
                .map(this::convertToDto)
                .collect(Collectors.toSet());
    }

    public ReservationDto updateReserevation(ReservationDto reservationDto){
        return convertToDto(reservationRepository.save(
                reservationRepository.findById(reservationDto.getId()).orElseThrow(ReservationNotFoundException::new)));
    }

    public ReservationDto createReservation(ReservationDto reservationDto){
        return convertToDto(reservationRepository.save(convertToEntity(reservationDto)));
    }

    public void deleteReservation(ReservationDto reservationDto){
        reservationRepository.delete(reservationRepository.findById(reservationDto.getId()).orElseThrow(ReservationNotFoundException::new));
    }

    private ReservationDto convertToDto(ReservationEntity reservationEntity){
        return modelMapper.map(reservationEntity, ReservationDto.class);
    }

    private ReservationEntity convertToEntity(ReservationDto reservationDto){
        return modelMapper.map(reservationDto, ReservationEntity.class);
    }

}
