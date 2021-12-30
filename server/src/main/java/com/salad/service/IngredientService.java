package com.salad.service;

import com.salad.dto.IngredientResponseDto;
import com.salad.dto.SaveIngredientRequestDto;
import com.salad.entity.Ingredient;
import com.salad.entity.Salad;
import com.salad.entity.Vegetable;
import com.salad.exception.IngredientNotFoundException;
import com.salad.exception.SaladNotFoundException;
import com.salad.exception.VegetableNotFoundException;
import com.salad.repository.IngredientRepository;
import com.salad.repository.SaladRepository;
import com.salad.repository.VegetableRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    @Autowired
    SaladRepository saladRepository;

    @Autowired
    VegetableRepository vegetableRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    public IngredientResponseDto save(SaveIngredientRequestDto saveIngredientRequestDto) {
        ModelMapper mapper = new ModelMapper();

        Long saladId = saveIngredientRequestDto.getSaladId();
        Salad salad = saladRepository.findById(saladId).orElse(null);

        if(salad == null) {
            throw new SaladNotFoundException(saladId);
        }

        Long vegetableId = saveIngredientRequestDto.getVegetableId();
        Vegetable vegetable = vegetableRepository.findById(vegetableId).orElse(null);

        if(vegetable == null) {
            throw new VegetableNotFoundException(vegetableId);
        }


        Ingredient ingredient = new Ingredient();
        ingredient.setSalad(salad);
        ingredient.setVegetable(vegetable);
        ingredient.setMass(saveIngredientRequestDto.getMass());

        ingredientRepository.save(ingredient);

        return mapper.map(ingredient, IngredientResponseDto.class);
    }

    public void delete(Long id) {
        Ingredient ingredient = ingredientRepository.findById(id).orElse(null);

        if(ingredient == null) {
            throw new IngredientNotFoundException(id);
        }

        ingredientRepository.delete(ingredient);
    }
}
