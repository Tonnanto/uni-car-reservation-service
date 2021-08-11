package view;

import controller.Command;
import controller.ContentService;
import model.File;

public class ShowFileView extends StringInputView {

    ContentService contentService;
    File file;
    public ShowFileView(ContentService contentService, File file) {
        this.contentService = contentService;
        this.file = file;
    }

    @Override
    protected Command getCommand(String inputString) {
        return null;
    }

    @Override
    protected String getMessage() {
        return null;
    }
}
