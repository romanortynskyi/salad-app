package com.salad.controller;

import com.salad.dto.salad.request.SaveSaladRequestDto;
import com.salad.dto.salad.request.UpdateSaladRequestDto;
import com.salad.dto.salad.response.SaladResponseDto;
import com.salad.service.SaladService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/salads")
public class SaladController {

    @Autowired
    SaladService saladService;

    @PostMapping
    public SaladResponseDto saveSalad(@RequestBody @Validated SaveSaladRequestDto saveSaladRequestDto) {
        SaladResponseDto saladResponseDto = saladService.save(saveSaladRequestDto);
        return saladResponseDto;
    }

    @GetMapping
    public List<SaladResponseDto> getAllSalads() {
        return saladService.findAll();
    }

    @GetMapping("/{id}")
    public SaladResponseDto getSaladById(@PathVariable Long id) {
        return saladService.findById(id);
    }

    @PutMapping("/{id}")
    public SaladResponseDto updateSalad(
            @PathVariable Long id,
            @RequestBody @Validated UpdateSaladRequestDto updateSaladRequestDto
    ) {
        return saladService.update(id, updateSaladRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteSalad(@PathVariable Long id) {
        saladService.delete(id);
    }
}
