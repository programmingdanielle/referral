package com.wildwoodim.specialist.models.forms;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Specialist {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String specialistType;

    @NotNull
    @Size(min=3, max=50)
    private String specialistName;

    @NotNull
    @Size(min=3, max=50)
    private String specialistLocation;

    @NotNull
    @Pattern(regexp = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}",
            message = "Invalid phone number")
    private String specialistContact;

    public Specialist() {}

    @ManyToOne
    private Insurance insurance;

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) { this.insurance = insurance;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Specialist(String specialistType) { this.specialistType = specialistType; }

    public String getSpecialistName() {
        return specialistName;
    }

    public void setSpecialistName(String specialistName) {
        this.specialistName = specialistName;
    }

    public String getSpecialistLocation() {
        return specialistLocation;
    }

    public void setSpecialistLocation(String specialistLocation) {
        this.specialistLocation = specialistLocation;
    }

    public String getSpecialistType() {
        return specialistType;
    }

    public void setSpecialistType(String specialistType) {
        this.specialistType = specialistType;
    }

    public String getSpecialistContact() {
        return specialistContact;
    }

    public void setSpecialistContact(String specialistContact) {
        this.specialistContact = specialistContact;
    }
}
