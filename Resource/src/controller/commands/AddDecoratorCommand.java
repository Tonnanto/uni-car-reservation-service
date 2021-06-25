package controller.commands;

import model.Resource;
import model.decorator.CarDecoratorType;
import model.decorator.ChildSeat;
import model.decorator.SetTopBox;

public class AddDecoratorCommand extends ResourceServiceCommand {

    private final CarDecoratorType decoratorType;

    public AddDecoratorCommand(CarDecoratorType decoratorType) {
        this.decoratorType = decoratorType;
    }


    @Override
    public void execute() {
        if (receiver.getResource() == null) return;

        Resource resource = receiver.getResource();

        resource = switch (decoratorType) {
            case CHILD_SEAT -> new ChildSeat(resource);
            case SET_TOP_BOX -> new SetTopBox(resource);
        };

        receiver.setResource(resource);
    }

    @Override
    public String getDescription() {
        return decoratorType.getName();
    }
}
