package controller.commands;

import controller.PersonService;
import view.Language;

public class ResetSelectionCommand extends PersonServiceCommand {
    public ResetSelectionCommand(PersonService receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.resetSelection();
    }

    @Override
    public String getDescription() {
        return Language.resourceBundle.getString("person.controller.commands.ResetSelectionCommand.Description");
    }
}