package pl.christopherk.BowlingAlley.persistance.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "track")
public class TrackEntity extends AbstractEntity{

    private String name;
    private int number;
    private boolean isActive;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
