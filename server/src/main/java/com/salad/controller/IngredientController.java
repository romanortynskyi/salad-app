package com.salad.controller;

import com.salad.dto.IngredientResponseDto;
import com.salad.dto.SaveIngredientRequestDto;
import com.salad.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/ingredients")
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @PostMapping
    public IngredientResponseDto saveIngredient(@RequestBody @Validated SaveIngredientRequestDto saveIngredientRequestDto) {
        IngredientResponseDto ingredientResponseDto = ingredientService.save(saveIngredientRequestDto);
        return ingredientResponseDto;
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable Long id) {
        ingredientService.delete(id);
    }
}
