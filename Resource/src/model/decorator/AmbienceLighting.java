package model.decorator;

import model.Resource;

public class AmbienceLighting extends CarDecorator {
    public AmbienceLighting(Resource resource) {
        super(resource);
    }

    @SuppressWarnings("unused")
    @Override
    public String getName() {
        return CarDecoratorType.AMBIENCE_LIGHTING.getName();
    }

    @Override
    public CarDecoratorType getDecoratorType() {
        return CarDecoratorType.AMBIENCE_LIGHTING;
    }
}
