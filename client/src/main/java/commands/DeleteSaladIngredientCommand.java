package commands;

import exceptions.NotFoundException;
//import services.Services;
import services.SaladService;
import utils.AppLogger;

import java.io.IOException;
import java.util.UUID;
import java.util.logging.Logger;

public class DeleteSaladIngredientCommand implements ICommand {
    private Logger logger = AppLogger.getInstance();
    private SaladService saladService = SaladService.getInstance();
    private Long ingredientId;

    public DeleteSaladIngredientCommand(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException, NotFoundException, InterruptedException {
        saladService.deleteIngredient(ingredientId);

        String msg = String.format("Delete ingredient: %s", ingredientId);
        logger.info(msg);
    }
}
