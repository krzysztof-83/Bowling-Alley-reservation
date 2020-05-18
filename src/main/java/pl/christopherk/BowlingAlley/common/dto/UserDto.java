package pl.christopherk.BowlingAlley.common.dto;

import javax.validation.constraints.NotBlank;

public class UserDto {

    private Long id;
    private Long version;

    @NotBlank(message = "First name may not be blank")
    private String name;

    @NotBlank(message = "Surname may not be blank")
    private String surname;

    @NotBlank(message = "Email may not be blank")
    private String email;

    @NotBlank(message = "Password may not be blank")
    private String password;
    private boolean active;

    @NotBlank(message = "Role may not be blank")
    private String userRole;

    public Long getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
