package controller.commands;

import controller.ResourceService;

public class ResetSelectionCommand extends ResourceServiceCommand {
    public ResetSelectionCommand(ResourceService receiver) {
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