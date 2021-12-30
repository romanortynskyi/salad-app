package commands;

import exceptions.NotFoundException;
import validations.ValidationErrorException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {
    private static final CommandExecutor instance = new CommandExecutor();
    private static final List<ICommand> commands = new ArrayList<>();

    private CommandExecutor() {}

    public static CommandExecutor getInstance() {
        return instance;
    }

    public void add(ICommand command) {
        commands.add(command);
    }

    public void reset() {
        commands.clear();
    }

    public void execute() throws NotFoundException, IOException, ClassNotFoundException, ValidationErrorException, InterruptedException {
        for(ICommand c: commands) {
            c.execute();
        }

        reset();
    }
}
