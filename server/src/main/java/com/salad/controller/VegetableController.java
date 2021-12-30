package com.salad.controller;

import com.salad.dto.vegetable.request.UpdateVegetableRequestDto;
import com.salad.service.VegetableService;
import com.salad.dto.vegetable.request.SaveVegetableRequestDto;
import com.salad.dto.vegetable.response.VegetableResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vegetables")
public class VegetableController {

    @Autowired
    VegetableService vegetableService;

    @PostMapping
    public VegetableResponseDto saveVegetable(@RequestBody @Validated SaveVegetableRequestDto saveVegetableRequestDto) {
        VegetableResponseDto vegetableResponseDto = vegetableService.save(saveVegetableRequestDto);
        return vegetableResponseDto;
    }

    @GetMapping
    public List<VegetableResponseDto> getAllVegetables() {
        return vegetableService.findAll();
    }

    @GetMapping("/{id}")
    public VegetableResponseDto getVegetableById(@PathVariable Long id) {
        return vegetableService.findById(id);
    }

    @PutMapping("/{id}")
    public VegetableResponseDto updateVegetable(
            @PathVariable Long id,
            @RequestBody @Validated UpdateVegetableRequestDto updateVegetableRequestDto
    ) {
        return vegetableService.update(id, updateVegetableRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVegetable(@PathVariable Long id) {
        vegetableService.delete(id);
    }
}
