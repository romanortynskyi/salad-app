package com.salad.service;

import com.salad.dto.salad.request.SaveSaladRequestDto;
import com.salad.dto.salad.request.UpdateSaladRequestDto;
import com.salad.dto.salad.response.SaladResponseDto;
import com.salad.entity.Ingredient;
import com.salad.entity.Salad;
import com.salad.entity.Vegetable;
import com.salad.exception.SaladNotFoundException;
import com.salad.exception.VegetableNotFoundException;
import com.salad.repository.IngredientRepository;
import com.salad.repository.SaladRepository;
import com.salad.repository.VegetableRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaladService {
    @Autowired
    private SaladRepository saladRepository;

    @Autowired
    private VegetableRepository vegetableRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    public SaladResponseDto save(SaveSaladRequestDto saveSaladRequestDto) {
        ModelMapper mapper = new ModelMapper();
        Salad salad = new Salad();

        salad.setName(saveSaladRequestDto.getName());

        saladRepository.save(salad);

        List<Ingredient> ingredients = new ArrayList<>();

        saveSaladRequestDto.getIngredients().forEach(i -> {
            Ingredient ingredient = new Ingredient();
            ingredient.setMass(i.getMass());
            ingredient.setVegetable(vegetableRepository.findById(i.getVegetableId()).get());
            ingredient.setSalad(saladRepository.findById(salad.getId()).get());

            ingredientRepository.save(ingredient);
            ingredients.add(ingredient);
        });

        salad.setIngredients(ingredients);

        return mapper.map(salad, SaladResponseDto.class);
    }

    public List<SaladResponseDto> findAll() {
        ModelMapper mapper = new ModelMapper();
        List<Salad> salads = (List<Salad>) saladRepository.findAll();
        return salads.stream()
                .map(s -> mapper.map(s, SaladResponseDto.class))
                .collect(Collectors.toList());
    }

    public SaladResponseDto findById(Long id) {
        ModelMapper mapper = new ModelMapper();
        Salad salad = saladRepository.findById(id).orElse(null);

        if(salad == null) {
            throw new SaladNotFoundException(id);
        }

        return mapper.map(salad, SaladResponseDto.class);
    }

    public SaladResponseDto update(Long id, UpdateSaladRequestDto updateSaladRequestDto) {
        ModelMapper mapper = new ModelMapper();

        Salad salad = saladRepository.findById(id).orElse(null);

        if(salad == null) {
            throw new VegetableNotFoundException(id);
        }

        salad.setName(updateSaladRequestDto.getName());

        saladRepository.save(salad);

        return mapper.map(salad, SaladResponseDto.class);
    }

    @Transactional
    public void delete(Long id) {
        Salad salad = saladRepository.findById(id).orElse(null);

        if(salad == null) {
            throw new SaladNotFoundException(id);
        }

        salad.getIngredients().forEach(i -> {
            ingredientRepository.delete(i);
        });

        saladRepository.delete(salad);
    }
}
