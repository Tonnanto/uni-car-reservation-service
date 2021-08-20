package model.decorator;

import model.Resource;

public class SetTopBox extends CarDecorator {
    public SetTopBox(Resource resource) {
        super(resource);
    }

    @Override
    public String getName() {
        return CarDecoratorType.SET_TOP_BOX.getName();
    }

    @Override
    public CarDecoratorType getDecoratorType() {
        return CarDecoratorType.SET_TOP_BOX;
    }
}
