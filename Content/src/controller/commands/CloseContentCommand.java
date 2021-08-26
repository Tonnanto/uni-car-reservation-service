package controller.commands;

import controller.Config;
import controller.ContentService;

public class CloseContentCommand extends ContentServiceCommand {
    public CloseContentCommand(ContentService receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.closeContent();
    }

    @Override
    public String getDescription() {
        return Config.resourceBundle.getString("content.controller.commands.CloseContentCommand.Description");
    }
}
