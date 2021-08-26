package view;

import controller.Command;
import controller.Config;
import controller.ResourceService;
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
        return Config.resourceBundle.getString("resource.SelectCarView.Message");
    }

    @Override
    protected List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();

        // Add an AddDecoratorCommand for each CarDecoratorType
        for (Car car : resourceService.getAvailableCars()) {
            SelectCarCommand selectCarCommand = new SelectCarCommand(resourceService, car);
            commands.add(selectCarCommand);
        }

        return commands;
    }
}
