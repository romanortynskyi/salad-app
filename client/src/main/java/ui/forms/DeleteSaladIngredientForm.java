package ui.forms;

import data.models.Ingredient;
import data.models.Salad;
import validations.IdValidation;
import validations.ValidationErrorException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DeleteSaladIngredientForm extends Form<Long> {
    @Override
    public Long show() throws IOException, ClassNotFoundException, ValidationErrorException {
        String ingredientIdStr = read("Id інгредієнта: ", new IdValidation());
        if(ingredientIdStr == null) return null;

        Long ingredientId = Long.parseLong(ingredientIdStr);

        return ingredientId;
    }
}
