package controller.commands;

import controller.Config;
import controller.PersonService;

public class FinishSelectionCommand extends PersonServiceCommand {
    public FinishSelectionCommand(PersonService receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.finishSelection();
    }

    @Override
    public String getDescription() {
        return Config.resourceBundle.getString("person.controller.commands.FinishSelectionCommand.Description");
    }
}
