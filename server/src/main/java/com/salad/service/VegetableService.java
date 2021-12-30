package com.salad.service;

import com.salad.dto.vegetable.request.SaveVegetableRequestDto;
import com.salad.dto.vegetable.request.UpdateVegetableRequestDto;
import com.salad.dto.vegetable.response.VegetableResponseDto;
import com.salad.entity.Vegetable;
import com.salad.exception.VegetableNotFoundException;
import com.salad.repository.IngredientRepository;
import com.salad.repository.VegetableRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VegetableService {
    @Autowired
    private VegetableRepository vegetableRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    public VegetableResponseDto save(SaveVegetableRequestDto saveVegetableRequestDto) {
        ModelMapper mapper = new ModelMapper();
        Vegetable vegetable = mapper.map(saveVegetableRequestDto, Vegetable.class);
        vegetableRepository.save(vegetable);

        return mapper.map(vegetable, VegetableResponseDto.class);
    }

    public List<VegetableResponseDto> findAll() {
        ModelMapper mapper = new ModelMapper();
        List<Vegetable> vegetables = (List<Vegetable>) vegetableRepository.findAll();
        return vegetables.stream()
                .map(v -> mapper.map(v, VegetableResponseDto.class))
                .collect(Collectors.toList());
    }

    public VegetableResponseDto findById(Long id) {
        ModelMapper mapper = new ModelMapper();
        Vegetable vegetable = vegetableRepository.findById(id).orElse(null);

        if(vegetable == null) {
            throw new VegetableNotFoundException(id);
        }

        return mapper.map(vegetable, VegetableResponseDto.class);
    }

    public VegetableResponseDto update(Long id, UpdateVegetableRequestDto updateVegetableRequestDto) {
        ModelMapper mapper = new ModelMapper();

        Vegetable vegetable = vegetableRepository.findById(id).orElse(null);

        if(vegetable == null) {
            throw new VegetableNotFoundException(id);
        }

        vegetable.setName(updateVegetableRequestDto.getName());
        vegetable.setCalories(updateVegetableRequestDto.getCalories());

        vegetableRepository.save(vegetable);

        return mapper.map(vegetable, VegetableResponseDto.class);
    }

    @Transactional
    public void delete(Long id) {
        Vegetable vegetable = vegetableRepository.findById(id).orElse(null);

        if(vegetable == null) {
            throw new VegetableNotFoundException(id);
        }

        vegetable.getIngredients().forEach(i -> {
            ingredientRepository.delete(i);
        });

        vegetableRepository.delete(vegetable);
    }
}
