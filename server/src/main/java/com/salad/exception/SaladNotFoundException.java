package com.salad.exception;

public class SaladNotFoundException extends NotFoundException {
    private Long id;

    public SaladNotFoundException(Long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        String message = String.format("Salad %s does not exist", id);
        return message;
    }
}
