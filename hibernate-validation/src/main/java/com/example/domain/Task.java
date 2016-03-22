package com.example.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Task {

    @NotEmpty(message = "Name can not be empty")
    private String name;

    @NotEmpty(message = "Description is mandatory")
    private String description;

    @NotNull(message = "Unit is empty")
    @Min(value = 0, message = "Invalid units")
    private Integer units;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }
}
