package view;

import controller.*;
import controller.commands.ResetSelectionCommand;
import controller.commands.SelectCarCommand;
import model.Car;

import java.util.ArrayList;
import java.util.List;

public class SelectCarView extends SelectionView {

    private final ResourceService resourceService;

    public SelectCarView(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @Override
    protected String getMessage() {
        return "Please select a car:";
    }

    @Override
    protected List<Command> getSelectionOptions() {
        List<Command> commands = new ArrayList<>();
        ResetSelectionCommand command;

        // Add an AddDecoratorCommand for each CarDecoratorType
        for (Car car: resourceService.getAvailableCars()) {
            SelectCarCommand selectCarCommand = new SelectCarCommand(car);
            selectCarCommand.setReceiver(resourceService);
            commands.add(selectCarCommand);
        }

        return commands;
    }
}
