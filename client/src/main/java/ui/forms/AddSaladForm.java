package ui.forms;

import data.models.Ingredient;
import data.models.Salad;
import data.models.Vegetable;
import dto.SaveSaladDto;
import dto.SaveSaladIngredientDto;
import utils.ConsoleUtils;
import validations.IdValidation;
import validations.MassValidation;
import validations.NameValidation;
import validations.ValidationErrorException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddSaladForm extends Form<SaveSaladDto> {
    private List<SaveSaladIngredientDto> readIngredients() throws IOException, ClassNotFoundException, ValidationErrorException {
        List<SaveSaladIngredientDto> ingredients = new ArrayList<>();

        ConsoleUtils.writeLine("Інгредієнти: ");

        while(true) {
            String vegetableIdStr;
            Long vegetableId;
            try {
                vegetableIdStr = read("Id овоча: ", new IdValidation());
                if(vegetableIdStr == null) break;
                vegetableId = Long.parseLong(vegetableIdStr);
            }
            catch (ValidationErrorException e) {
                ConsoleUtils.writeLine(e.getMessage());
                break;
            }

            double mass = Double.parseDouble(read("Маса: ", new MassValidation()));

            if(vegetableId != null) {
                SaveSaladIngredientDto saveSaladIngredientDto = new SaveSaladIngredientDto(vegetableId, mass);
                ingredients.add(saveSaladIngredientDto);
            }
            else break;
        }

        return ingredients;
    }

    @Override
    public SaveSaladDto show() throws IOException, ClassNotFoundException, ValidationErrorException {
        String name = read("Назва: ", new NameValidation());
        if(name == null) return null;

        List<SaveSaladIngredientDto> ingredients = readIngredients();
        if(ingredients.size() == 0) return null;

        SaveSaladDto salad = new SaveSaladDto(name, ingredients);

        return salad;
    }
}
