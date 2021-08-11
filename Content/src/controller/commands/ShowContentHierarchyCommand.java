package controller.commands;

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
        return "Show the entire content hierarchy";
    }
}
