package view;

import controller.Command;
import controller.ResourceService;
import controller.commands.AddDecoratorCommand;
import controller.commands.FinishResourceSelectionCommand;
import controller.commands.ResetResourceSelectionCommand;
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
        return Language.resourceBundle.getString("resource.AddCarDecoratorView.Message");
    }

    @Override
    protected List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();
        ResourceServiceCommand command;

        // Add an AddDecoratorCommand for each CarDecoratorType
        for (CarDecoratorType decoratorType : CarDecoratorType.values()) {
            if (decoratorType.canBeAddedMoreThanOnce() || !resourceService.getResource().containsDecoratorType(decoratorType)) {
                AddDecoratorCommand decoratorCommand = new AddDecoratorCommand(resourceService, decoratorType);
                commands.add(decoratorCommand);
            }
        }

        // Add empty line
        commands.add(null);

        // Reset Selection Command
        command = new ResetResourceSelectionCommand(resourceService);
        commands.add(command);

        // Finish Selection Command
        command = new FinishResourceSelectionCommand(resourceService);
        commands.add(command);

        return commands;
    }
}
