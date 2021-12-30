package com.salad.dto.salad.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class UpdateSaladRequestDto {
    @Pattern(regexp = "[a-zA-Zа-яєіїА-ЯЄЇ]{2,}") // at least 2 characters
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
