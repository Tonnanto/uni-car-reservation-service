package controller.commands;

import controller.ContentService;
import model.Content;

public class OpenContentCommand extends ContentServiceCommand {

    private Content content;

    public OpenContentCommand(ContentService receiver, Content content) {
        super(receiver);
        this.content = content;
    }

    @Override
    public void execute() {
        receiver.openContent(content);
    }

    @Override
    public String getDescription() {
        return content.getName();
    }
}
