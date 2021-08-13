package controller.commands;

import controller.ResourceService;
import view.Language;

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
        return Language.resourceBundle.getString("resource.controller.commands.ResetSelectionCommand.Description");
    }
}
