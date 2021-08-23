package model.decorator;

import model.Resource;

public class WindowShade extends CarDecorator {
    public WindowShade(Resource resource) {
        super(resource);
    }

    @Override
    public String getName() {
        return CarDecoratorType.WINDOW_SHADE.getName();
    }

    @Override
    public CarDecoratorType getDecoratorType() {
        return CarDecoratorType.WINDOW_SHADE;
    }
}