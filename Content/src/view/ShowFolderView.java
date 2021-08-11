package view;

import controller.Command;
import controller.ContentService;
import model.Folder;

import java.util.List;

public class ShowFolderView extends SelectionView {

    ContentService contentService;
    Folder folder;
    public ShowFolderView(ContentService contentService, Folder folder) {
        this.contentService = contentService;
        this.folder = folder;
    }

    @Override
    protected List<Command> getCommands() {
        return null;
    }

    @Override
    protected String getMessage() {
        return null;
    }
}
