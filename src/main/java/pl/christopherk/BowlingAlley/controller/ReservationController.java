package pl.christopherk.BowlingAlley.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.christopherk.BowlingAlley.common.dto.ReservationDto;
import pl.christopherk.BowlingAlley.service.ReservationService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public Collection<ReservationDto> getReservations(){
        return reservationService.getAllReservations();
    }

    @GetMapping(value = "/track/{trackName}")
    public Collection<ReservationDto> getReservationsByTrackName(@PathVariable("trackName") String trackName){
        return reservationService.getReservationByTrackName(trackName);
    }

    @GetMapping(value = "/user/{email}")
    public Collection<ReservationDto> getReservationsCreatedByUser(@PathVariable("email") String email){
        return reservationService.getReservationsCreatedByUser(email);
    }

    @GetMapping("/date")
    public Collection<ReservationDto> getReservationsByDate(@RequestParam("date")
                                                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date){
//
//        DateTimeFormatter dateTimeFormat = DateTimeFormatter.BASIC_ISO_DATE;
//        LocalDateTime dateConvert = dateTimeFormat.parse(date, LocalDateTime::from);
        return reservationService.getReservationsByDate(date);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationDto addNewReservation(@Valid @RequestBody ReservationDto reservationDto){
        return reservationService.createReservation(reservationDto);
    }
}
