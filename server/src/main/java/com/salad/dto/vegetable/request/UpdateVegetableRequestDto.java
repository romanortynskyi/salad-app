package com.salad.dto.vegetable.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class UpdateVegetableRequestDto {
    @Pattern(
            regexp = "[a-zA-Zа-яєіїА-ЯЄЇ]{2,}",
            message = "Name should be at least 2 characters long and contain letters only"
    )
    private String name;

    @Min(value = 1, message = "Calories should be greater than or equal to 1")
    private Double calories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }
}
