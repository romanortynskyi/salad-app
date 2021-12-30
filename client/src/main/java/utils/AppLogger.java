package utils;

import java.io.IOException;
import java.util.logging.*;

public class AppLogger {
    private static Logger LOGGER;

    public static void initialize() throws IOException {
        LOGGER = java.util.logging.Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
        FileHandler fh = new FileHandler("log.log");
        LOGGER.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
    }

    public static Logger getInstance() {
        return LOGGER;
    }
}
