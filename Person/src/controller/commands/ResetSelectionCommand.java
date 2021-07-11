package controller.commands;

import controller.PersonService;

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
        return "Reset Selection";
    }
}