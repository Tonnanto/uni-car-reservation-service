package controller.commands;

import controller.Config;
import controller.ResourceService;

public class ResetResourceSelectionCommand extends ResourceServiceCommand {
    public ResetResourceSelectionCommand(ResourceService receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.resetSelection();
    }

    @Override
    public String getDescription() {
        return Config.resourceBundle.getString("resource.controller.commands.ResetSelectionCommand.Description");
    }
}
