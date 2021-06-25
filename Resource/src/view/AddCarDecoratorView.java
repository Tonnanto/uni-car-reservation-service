package view;

import controller.*;
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
    protected List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();
        ResourceServiceCommand command;

        // Add an AddDecoratorCommand for each CarDecoratorType
        for (CarDecoratorType decoratorType: CarDecoratorType.values()) {
            AddDecoratorCommand decoratorCommand = new AddDecoratorCommand(decoratorType);
            decoratorCommand.setReceiver(resourceService);
            commands.add(decoratorCommand);
        }

        // Reset Selection Command
        command = new ResetSelectionCommand();
        command.setReceiver(resourceService);
        commands.add(command);

        // Finish Selection Command
        command = new FinishSelectionCommand();
        command.setReceiver(resourceService);
        commands.add(command);

        return commands;
    }
}
