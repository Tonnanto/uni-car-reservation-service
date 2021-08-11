package controller.commands;

import controller.ContentService;

public class CancelCommand extends ContentServiceCommand {
    public CancelCommand(ContentService receiver) {
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
