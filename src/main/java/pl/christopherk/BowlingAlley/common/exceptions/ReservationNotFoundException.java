package pl.christopherk.BowlingAlley.common.exceptions;

public class ReservationNotFoundException extends RuntimeException {

    public ReservationNotFoundException() {
        super("Could not found reservation: ");
    }
}
