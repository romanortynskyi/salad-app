package commands;

//import services.Services;
import data.models.Salad;
import services.SaladService;
import utils.AppLogger;
import utils.ConsoleUtils;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class GetAllSaladsCommand implements ICommand {
    private Logger logger = AppLogger.getInstance();
    private SaladService saladService = SaladService.getInstance();

    @Override
    public void execute() throws IOException, ClassNotFoundException, InterruptedException {
        List<Salad> salads = saladService.getAll();
        salads.forEach(s -> ConsoleUtils.writeLine(s));

        String msg = String.format("Get all salads: %s", salads);
        logger.info(msg);
    }
}
