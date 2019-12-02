package com.wildwoodim.specialist.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rating {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
            private String star;

    @NotNull
            private int value;

    public Rating() {}

    @OneToMany
    @JoinColumn(name = "rating_id")
    private List<Specialist> specialists = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
