package view;

import controller.Command;
import controller.ContentService;
import controller.commands.CancelCommand;
import controller.commands.CloseContentCommand;
import model.File;

import java.util.ArrayList;
import java.util.List;

public class ShowFileView extends SelectionView {

    ContentService contentService;
    File file;
    public ShowFileView(ContentService contentService, File file) {
        this.contentService = contentService;
        this.file = file;
    }

    @Override
    protected List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();

        commands.add(null);

        // Command to navigate back
        if (contentService.getNavigationPath().size() > 0) {
            commands.add(new CloseContentCommand(contentService));
        }

        // Command to end the navigation
        commands.add(new CancelCommand(contentService));

        return commands;
    }

    @Override
    protected String getMessage() {
        StringBuilder message = new StringBuilder();

        message.append("> ").append(this.contentService.getRoot().getName());

        for (String s: this.contentService.getNavigationPath()) {
            message.append("/").append(s);
        }
        message.append(":\n");

        message.append(file.toString());

        return message.toString();
    }
}
