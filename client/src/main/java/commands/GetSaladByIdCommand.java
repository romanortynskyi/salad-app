package commands;

import data.models.Salad;
import exceptions.NotFoundException;
import exceptions.SaladNotFoundException;
import services.SaladService;
import utils.AppLogger;
import utils.ConsoleUtils;

import java.io.IOException;
import java.util.UUID;
import java.util.logging.Logger;

public class GetSaladByIdCommand implements ICommand {
    private Logger logger = AppLogger.getInstance();
    private SaladService saladService = SaladService.getInstance();
    private Long id;

    public GetSaladByIdCommand(Long id) {
        this.id = id;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException, NotFoundException, InterruptedException {
        Salad salad = saladService.getById(id);
        ConsoleUtils.writeLine(salad);
        String msg = String.format("Get salad by id %s: %s", id, salad);
        logger.info(msg);
    }
}
