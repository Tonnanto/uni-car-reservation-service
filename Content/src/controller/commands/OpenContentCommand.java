package controller.commands;

import controller.ContentService;

public class OpenContentCommand extends ContentServiceCommand {
    public OpenContentCommand(ContentService receiver) {
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
