package model.decorator;

import model.Resource;

public class ChildSeat extends CarDecorator {
    public ChildSeat(Resource resource) {
        super(resource);
    }

    @Override
    public double getPrice() {
        return this.resource.getPrice() + 30.0;
    }

    @Override
    public String getName() {
        return "Child Seat";
    }
}
