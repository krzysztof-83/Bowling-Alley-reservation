package pl.christopherk.BowlingAlley.common.dto;

import javax.validation.constraints.NotBlank;

public class TrackDto {

    private Long id;
    private Long version;

    @NotBlank(message = "Name may not be blank")
    private String name;

    @NotBlank(message = "Number may not be blank")
    private int number;
    private boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

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
