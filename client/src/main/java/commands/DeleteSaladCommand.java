package commands;

import exceptions.NotFoundException;
import services.SaladService;
import utils.AppLogger;

import java.io.IOException;
import java.util.logging.Logger;

public class DeleteSaladCommand implements ICommand {
    private Logger logger = AppLogger.getInstance();
    private SaladService saladService = SaladService.getInstance();
    private Long id;

    public DeleteSaladCommand(Long id) {
        this.id = id;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException, NotFoundException, InterruptedException {
        saladService.delete(id);
        String msg = String.format("Delete salad %s", id);
        logger.info(msg);
    }
}
