package controller.commands;

import controller.Config;
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
        return Config.resourceBundle.getString("resource.controller.commands.FinishSelectionCommand.Description");
    }
}

