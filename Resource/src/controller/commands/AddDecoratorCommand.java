package controller.commands;

import controller.ResourceService;
import model.decorator.CarDecoratorType;

public class AddDecoratorCommand extends ResourceServiceCommand {

    private final CarDecoratorType decoratorType;

    public AddDecoratorCommand(ResourceService receiver, CarDecoratorType decoratorType) {
        super(receiver);
        this.decoratorType = decoratorType;
    }


    @Override
    public void execute() {
        receiver.addDecorator(decoratorType);
    }

    @Override
    public String getDescription() {
        return decoratorType.getName();
    }
}
