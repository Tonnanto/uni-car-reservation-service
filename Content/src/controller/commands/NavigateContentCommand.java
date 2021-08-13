package controller.commands;

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
        return "Navigate the content hierarchy";
    }
}
