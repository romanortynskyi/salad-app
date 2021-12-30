package ui.forms;

import data.models.Ingredient;
import data.models.Salad;
import data.models.Vegetable;
import dto.AddSaladIngredientDto;
import dto.SaveSaladIngredientDto;
import utils.ConsoleUtils;
import validations.IdValidation;
import validations.MassValidation;
import validations.ValidationErrorException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AddSaladIngredientForm extends Form<AddSaladIngredientDto> {

    private SaveSaladIngredientDto readIngredient() throws IOException, ClassNotFoundException, ValidationErrorException {
        ConsoleUtils.writeLine("Інгредієнт: ");
//
        String vegetableIdStr = read("Id овоча: ", new IdValidation());
        if(vegetableIdStr == null) return null;
//
        Long vegetableId = Long.parseLong(vegetableIdStr);
        double mass = Double.parseDouble(read("Маса: ", new MassValidation()));

        SaveSaladIngredientDto dto = new SaveSaladIngredientDto(vegetableId, mass);

        return dto;
    }

    @Override
    public AddSaladIngredientDto show() throws IOException, ClassNotFoundException, ValidationErrorException {
        String saladIdStr = read("Id салату: ", new IdValidation());
        if(saladIdStr == null) return null;

        Long saladId = Long.parseLong(saladIdStr);

        SaveSaladIngredientDto ingredient = readIngredient();
        if(ingredient == null) return null;

        AddSaladIngredientDto dto = new AddSaladIngredientDto(
                saladId,
                ingredient.getVegetableId(),
                ingredient.getMass()
        );

        return dto;
    }
}
