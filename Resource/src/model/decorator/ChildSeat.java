package model.decorator;

import model.Resource;

public class ChildSeat extends CarDecorator {
    public ChildSeat(Resource resource) {
        super(resource);
    }

    @Override
    public String getName() {
        return CarDecoratorType.CHILD_SEAT.getName();
    }

    @Override
    public CarDecoratorType getDecoratorType() {
        return CarDecoratorType.CHILD_SEAT;
    }
}
