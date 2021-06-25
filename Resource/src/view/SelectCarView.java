package view;

import controller.Command;
import controller.ResourceService;
import controller.commands.SelectCarCommand;
import model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class SelectCarView extends SelectionView {

    private final ResourceService resourceService;

    public SelectCarView(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @Override
    protected List<String> getSelectionOptions() {
        return resourceService.getAvailableCars().stream().map(Car::getDescription).collect(Collectors.toList());
    }

    @Override
    protected Command getCommand() {
        return new SelectCarCommand(resourceService);
    }

    @Override
    protected String getMessage() {
        return "Please select a car:";
    }
}
