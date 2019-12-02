package com.wildwoodim.specialist.models;

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

    @ManyToOne
    private Type type;

    @ManyToOne
    private Rating rating;

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Type getType() { return type; }

    public void setType(Type type) { this.type = type; }

    public void setInsurance(Insurance insurance) { this.insurance = insurance;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getSpecialistContact() {
        return specialistContact;
    }

    public void setSpecialistContact(String specialistContact) {
        this.specialistContact = specialistContact;
    }
}
