package controller.commands;

import controller.ResourceService;
import view.Language;

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
        return Language.resourceBundle.getString("resource.controller.commands.ResetSelectionCommand.Description");
    }
}
