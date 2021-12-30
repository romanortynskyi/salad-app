package com.salad.dto;

import javax.validation.constraints.Min;

public class SaveIngredientRequestDto {
    @Min(1)
    private Long vegetableId;
    @Min(1)
    private Long saladId;
    @Min(1)
    private Double mass;

    public Long getVegetableId() {
        return vegetableId;
    }

    public void setVegetableId(Long vegetableId) {
        this.vegetableId = vegetableId;
    }

    public Long getSaladId() {
        return saladId;
    }

    public void setSaladId(Long saladId) {
        this.saladId = saladId;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }
}
