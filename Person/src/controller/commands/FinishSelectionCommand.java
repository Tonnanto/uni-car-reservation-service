package controller.commands;

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
        return "Finish Selection";
    }
    //TODO Ein View fürs Ende
}
