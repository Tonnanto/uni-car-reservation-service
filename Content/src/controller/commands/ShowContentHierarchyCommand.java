package controller.commands;

import controller.Config;
import controller.ContentService;

public class ShowContentHierarchyCommand extends ContentServiceCommand {
    public ShowContentHierarchyCommand(ContentService receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.showContentHierarchy();
    }

    @Override
    public String getDescription() {
        return Config.resourceBundle.getString("content.controller.commands.ShowContentHierarchyCommand.Description");
    }
}
