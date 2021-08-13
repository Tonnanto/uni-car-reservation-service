package view;

import controller.Command;
import controller.ContentService;
import controller.commands.CancelCommand;
import controller.commands.CloseContentCommand;
import controller.commands.OpenContentCommand;
import model.Content;
import model.Folder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShowFolderView extends SelectionView {

    ContentService contentService;
    Folder folder;

    public ShowFolderView(ContentService contentService, Folder folder) {
        this.contentService = contentService;
        this.folder = folder;
    }

    @Override
    protected List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();

        // Commands to open content of this folder
        for (Map.Entry<String, Content> entry: folder.getContents().entrySet()) {
            commands.add(new OpenContentCommand(contentService, entry.getValue()));
        }

        commands.add(null);

        // Command to navigate back
        commands.add(new CloseContentCommand(contentService));

        // Command to end the navigation
        commands.add(new CancelCommand(contentService));

        return commands;
    }

    @Override
    protected String getMessage() {
        StringBuilder message = new StringBuilder("Select a directory or a file to open it.");

        message.append("\n\n> ").append(this.contentService.getRoot().getName());

        for (String s: this.contentService.getNavigationPath()) {
            message.append("/").append(s);
        }
        message.append(":");

        return message.toString();
    }
}
