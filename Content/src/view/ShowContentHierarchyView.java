package view;

import controller.Command;
import controller.ContentService;
import controller.commands.CancelCommand;
import controller.commands.CloseContentCommand;

import java.util.ArrayList;
import java.util.List;

public class ShowContentHierarchyView extends SelectionView {
    private final ContentService contentService;

    public ShowContentHierarchyView(ContentService contentService) {
        this.contentService = contentService;
    }

    @Override
    protected String getMessage() {
        return "Content Hierarchy: \n" + contentService.getRoot();
    }

    @Override
    protected List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();

        // Command to navigate back
        commands.add(new CloseContentCommand(contentService));

        // Command to end the navigation
        commands.add(new CancelCommand(contentService));

        return commands;
    }
}
