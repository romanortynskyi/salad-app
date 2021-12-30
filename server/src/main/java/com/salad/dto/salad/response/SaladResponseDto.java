package com.salad.dto.salad.response;

import com.salad.dto.IngredientResponseDto;

import java.util.List;

public class SaladResponseDto {
    private Long id;
    private String name;
    private Double calories;
    private List<IngredientResponseDto> ingredients;

    public Long getId() {
        return id;
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

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public List<IngredientResponseDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientResponseDto> ingredients) {
        this.ingredients = ingredients;
    }
}
