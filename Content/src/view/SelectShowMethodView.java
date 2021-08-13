package view;

import controller.Command;
import controller.ContentService;
import controller.commands.NavigateContentCommand;
import controller.commands.ShowContentHierarchyCommand;

import java.util.ArrayList;
import java.util.List;

public class SelectShowMethodView extends SelectionView {
    private ContentService contentService;

    public SelectShowMethodView(ContentService contentService) {
        this.contentService = contentService;
    }

    @Override
    protected List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new ShowContentHierarchyCommand(contentService));
        commands.add(new NavigateContentCommand(contentService));
        return commands;
    }

    @Override
    protected String getMessage() {
        return "How do you like the content displayed?";
    }
}
