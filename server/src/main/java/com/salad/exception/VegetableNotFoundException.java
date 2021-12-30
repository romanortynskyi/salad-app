package com.salad.exception;

public class VegetableNotFoundException extends NotFoundException {
    private Long id;

    public VegetableNotFoundException(Long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        String message = String.format("Vegetable %s does not exist", id);
        return message;
    }
}
