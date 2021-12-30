package com.salad.dto.salad.request;

import com.salad.dto.SaveIngredientRequestDto;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

public class SaveSaladRequestDto {
    @Pattern(
            regexp = "[a-zA-Zа-яєіїА-ЯЄЇ]{2,}",
            message = "Name should be at least 2 characters long and contain letters only"
    )
    private String name;

    private List<@Valid SaveIngredientRequestDto> ingredients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SaveIngredientRequestDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<SaveIngredientRequestDto> ingredients) {
        this.ingredients = ingredients;
    }
}
