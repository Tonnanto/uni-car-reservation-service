package controller.commands;

import controller.ResourceService;
import view.Language;

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
        return Language.resourceBundle.getString("resource.controller.commands.FinishSelectionCommand.Description");
    }
}

