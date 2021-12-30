package com.salad.dto;

import com.salad.dto.vegetable.response.VegetableResponseDto;

public class IngredientResponseDto {
    private Long id;
    private VegetableResponseDto vegetable;
    private Double mass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VegetableResponseDto getVegetable() {
        return vegetable;
    }

    public void setVegetable(VegetableResponseDto vegetable) {
        this.vegetable = vegetable;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }
}
