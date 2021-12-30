package ui.forms;

import validations.IdValidation;
import validations.ValidationErrorException;

import java.io.IOException;
import java.util.UUID;

public class SortSaladIngredientsByCaloriesForm extends Form<Long> {
    @Override
    public Long show() throws IOException, ValidationErrorException {
        String idStr = read("Id: ", new IdValidation());
        if(idStr == null) return null;

        Long id = Long.parseLong(idStr);

        return id;
    }
}
