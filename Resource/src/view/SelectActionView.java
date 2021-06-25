package view;

import controller.Command;
import controller.ResourceService;
import controller.commands.SelectActionCommand;

import java.util.Arrays;
import java.util.List;

public class SelectActionView extends SelectionView {

    private final ResourceService resourceService;

    public SelectActionView(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @Override
    protected String getMessage() {
        return "What to do next?";
    }

    @Override
    protected List<String> getSelectionOptions() {
        return Arrays.asList(
                "Add addons to your car",
                "Finish selection",
                "Remove selection"
        );
    }

    @Override
    protected Command getCommand() {
        return new SelectActionCommand(resourceService);
    }
}
