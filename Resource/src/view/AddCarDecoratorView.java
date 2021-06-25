package view;

import controller.Command;
import controller.ResourceService;

import java.util.List;

public class AddCarDecoratorView extends SelectionView {

    private final ResourceService resourceService;

    public AddCarDecoratorView(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @Override
    protected String getMessage() {
        return "Select an addon:";
    }

    @Override
    protected List<String> getSelectionOptions() {
        return null;
    }

    @Override
    protected Command getCommand() {
        return null;
    }
}
