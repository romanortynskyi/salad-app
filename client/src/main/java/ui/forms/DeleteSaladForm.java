package ui.forms;

import validations.IdValidation;
import validations.ValidationErrorException;

import java.io.IOException;

public class DeleteSaladForm extends Form<Long> {
    public Long show() throws IOException, ValidationErrorException {
        String idStr = read("Id: ", new IdValidation());
        if(idStr == null) return null;

        Long id = Long.parseLong(idStr);

        return id;
    }
}
