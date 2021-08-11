package controller.commands;

import controller.ContentService;

public class CloseContentCommand extends ContentServiceCommand {
    public CloseContentCommand(ContentService receiver) {
        super(receiver);
    }

    @Override
    public void execute() {

    }

    @Override
    public String getDescription() {
        return null;
    }
}
