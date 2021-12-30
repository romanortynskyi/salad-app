package commands;

import data.models.Ingredient;
import data.models.Salad;
import dto.AddSaladIngredientDto;
import exceptions.NotFoundException;
//import services.Services;
import services.SaladService;
import utils.AppLogger;
import utils.ConsoleUtils;

import java.io.IOException;
import java.util.UUID;
import java.util.logging.Logger;

public class AddSaladIngredientCommand implements ICommand {
    private Logger logger = AppLogger.getInstance();
    private SaladService saladService = SaladService.getInstance();
    private AddSaladIngredientDto addSaladIngredientDto;

    public AddSaladIngredientCommand(AddSaladIngredientDto addSaladIngredientDto) {
        this.addSaladIngredientDto = addSaladIngredientDto;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException, NotFoundException, InterruptedException {
        Ingredient ingredient = saladService.addIngredient(addSaladIngredientDto);

        ConsoleUtils.writeLine(ingredient);
        String msg = String.format("Add ingredient: %s", ingredient);
        logger.info(msg);
    }
}
