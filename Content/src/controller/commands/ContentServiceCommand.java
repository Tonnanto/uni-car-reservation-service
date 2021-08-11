package controller.commands;

import controller.Command;
import controller.ContentService;

public abstract class ContentServiceCommand implements Command {
    private final ContentService receiver;

    public ContentServiceCommand(ContentService receiver) {
        this.receiver = receiver;
    }
}
