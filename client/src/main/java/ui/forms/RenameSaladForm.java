package ui.forms;

import data.models.Salad;
import dto.UpdateSaladDto;
import validations.IdValidation;
import validations.NameValidation;
import validations.ValidationErrorException;

import java.io.IOException;
import java.util.UUID;

public class RenameSaladForm extends Form<UpdateSaladDto> {
    @Override
    public UpdateSaladDto show() throws IOException, ClassNotFoundException, ValidationErrorException {
        String idStr = read("Id: ", new IdValidation());
        if(idStr == null) return null;
        Long id = Long.parseLong(idStr);

        String name = read("Назва: ", new NameValidation());
        UpdateSaladDto salad = new UpdateSaladDto(id, name);

        return salad;
    }
}
