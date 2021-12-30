package commands;

import data.models.Ingredient;
import data.models.Salad;
import exceptions.NotFoundException;
import services.SaladService;
import utils.AppLogger;
import utils.ConsoleUtils;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SortSaladIngredientsByCaloriesCommand implements ICommand {
    private Logger logger = AppLogger.getInstance();
    private SaladService saladService = SaladService.getInstance();
    private Long id;

    public SortSaladIngredientsByCaloriesCommand(Long id) {
        this.id = id;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException, NotFoundException, InterruptedException {
        Salad salad = saladService.getById(id);
        List<Ingredient> ingredients = salad.getIngredients().stream()
                .sorted(Comparator.comparing(i -> i.getVegetable().getCalories()))
                .collect(Collectors.toList());
        ingredients.forEach(i -> ConsoleUtils.writeLine(i));
        String msg = String.format("Sort salad ingredients by calories (salad %s): ", ingredients);
        logger.info(msg);
    }
}
