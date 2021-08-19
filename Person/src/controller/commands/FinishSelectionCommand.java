package controller.commands;

import controller.PersonService;
import view.Language;

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
        return Language.resourceBundle.getString("person.controller.commands.FinishSelectionCommand.Description");
    }
}
