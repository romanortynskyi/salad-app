package ui.forms;
import data.models.Vegetable;
import validations.CaloriesValidation;
import validations.NameValidation;
import validations.ValidationErrorException;

import java.io.IOException;
import java.util.UUID;

public class AddVegetableForm extends Form<Vegetable> {
    @Override
    public Vegetable show() throws IOException, ValidationErrorException {
        String name = read("Назва: ", new NameValidation());
        if(name == null) return null;

        String caloriesStr = read("Калорії: ", new CaloriesValidation());
        if(caloriesStr == null) return null;

        double calories = Double.parseDouble(caloriesStr);

        Vegetable vegetable = new Vegetable(name, calories);

        return vegetable;
    }
}
