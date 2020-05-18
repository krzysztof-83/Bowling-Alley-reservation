package pl.christopherk.BowlingAlley.common.exceptions;

public class TrackNotFoundException extends RuntimeException {

    public TrackNotFoundException(Long id) {
        super("Could not found track: " + id);
    }
    public TrackNotFoundException(String name) {
        super("Could not found track: " + name);
    }
    public TrackNotFoundException(int number) {
        super("Could not found track: " + number);
    }
}
