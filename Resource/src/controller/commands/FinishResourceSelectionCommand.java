package controller.commands;

import controller.ResourceService;

public class FinishResourceSelectionCommand extends ResourceServiceCommand {
    public FinishResourceSelectionCommand(ResourceService receiver) {
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

