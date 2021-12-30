package commands;

import data.models.Salad;
import exceptions.NotFoundException;
import services.SaladService;
import utils.AppLogger;
import utils.ConsoleUtils;

import java.io.IOException;
import java.util.logging.Logger;

public class GetCaloriesBySaladCommand implements ICommand {
    private Logger logger = AppLogger.getInstance();
    private SaladService saladService = SaladService.getInstance();
    private Long id;

    public GetCaloriesBySaladCommand(Long id) {
        this.id = id;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException, NotFoundException, InterruptedException {
        Salad salad = saladService.getById(id);
        Double calories = salad.getIngredients().stream()
                .mapToDouble(i -> i.getVegetable().getCalories())
                .sum();

        ConsoleUtils.writeLine(calories);
        String msg = String.format("Get calories by salad %s: %s", id, calories);
        logger.info(msg);
    }
}
