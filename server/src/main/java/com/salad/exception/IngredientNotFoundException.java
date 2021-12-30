package com.salad.exception;

public class IngredientNotFoundException extends NotFoundException {
    private Long id;

    public IngredientNotFoundException(Long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        String message = String.format("Ingredient %s does not exist", id);
        return message;
    }
}
