package view;

import controller.Command;
import controller.ContentService;

public class ShowContentHierarchyView extends StringInputView {
    private final ContentService contentService;

    public ShowContentHierarchyView(ContentService contentService) {
        this.contentService = contentService;
    }

    @Override
    protected String getMessage() {
        return "Content Hierarchy: \n" + contentService.getRoot();
    }

    @Override
    protected Command getCommand(String inputString) {
        return null;
    }
}
