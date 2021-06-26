package controller.commands;

import model.decorator.CarDecoratorType;

public class AddDecoratorCommand extends ResourceServiceCommand {

    private final CarDecoratorType decoratorType;

    public AddDecoratorCommand(CarDecoratorType decoratorType) {
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
