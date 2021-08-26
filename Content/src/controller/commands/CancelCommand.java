package controller.commands;

import controller.Config;
import controller.ContentService;

public class CancelCommand extends ContentServiceCommand {
    public CancelCommand(ContentService receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.cancel();
    }

    @Override
    public String getDescription() {
        return Config.resourceBundle.getString("content.controller.commands.CancelCommand.Description");
    }
}
