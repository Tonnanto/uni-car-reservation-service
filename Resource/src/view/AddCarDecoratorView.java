package view;

import controller.Command;
import controller.ResourceService;
import controller.commands.AddDecoratorCommand;
import controller.commands.FinishSelectionCommand;
import controller.commands.ResetSelectionCommand;
import controller.commands.ResourceServiceCommand;
import model.decorator.CarDecoratorType;

import java.util.ArrayList;
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
    protected List<Command> getSelectionOptions() {
        List<Command> commands = new ArrayList<>();

        // Add an AddDecoratorCommand for each CarDecoratorType
        for (CarDecoratorType decoratorType: CarDecoratorType.values()) {
            AddDecoratorCommand decoratorCommand = new AddDecoratorCommand(resourceService, decoratorType);
            commands.add(decoratorCommand);
        }

        return commands;
    }

    @Override
    protected List<Command> getActions() {
        List<Command> commands = new ArrayList<>();
        ResourceServiceCommand command;

        // Reset Selection Command
        command = new ResetSelectionCommand(resourceService);
        commands.add(command);

        // Finish Selection Command
        command = new FinishSelectionCommand(resourceService);
        commands.add(command);

        return commands;
    }
}
