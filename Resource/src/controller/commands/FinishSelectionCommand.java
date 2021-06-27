package controller.commands;

import controller.ResourceService;

public class FinishSelectionCommand extends ResourceServiceCommand {
    public FinishSelectionCommand(ResourceService receiver) {
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
}

