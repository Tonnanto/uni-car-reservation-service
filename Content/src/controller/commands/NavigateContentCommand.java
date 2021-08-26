package controller.commands;

import controller.Config;
import controller.ContentService;

public class NavigateContentCommand extends ContentServiceCommand {
    public NavigateContentCommand(ContentService receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.navigateContent();
    }

    @Override
    public String getDescription() {
        return Config.resourceBundle.getString("content.controller.commands.NavigateContentCommand.Description");
    }
}
