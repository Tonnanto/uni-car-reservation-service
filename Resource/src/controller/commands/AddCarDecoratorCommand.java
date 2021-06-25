package controller.commands;

import controller.ResourceService;

public class AddCarDecoratorCommand extends ResourceServiceCommand {
    public AddCarDecoratorCommand(ResourceService receiver) {
        super(receiver);
    }

    @Override
    public void execute(int i) {
        // TODO: add decorator to resource
    }
}
