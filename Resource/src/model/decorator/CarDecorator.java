package model.decorator;

import model.Resource;

public abstract class CarDecorator implements Resource {

    protected final Resource resource;

    public CarDecorator(Resource resource) {
        this.resource = resource;
    }

    @Override
    public abstract double getPrice();

    @Override
    public abstract String getDescription();
}
