package model.decorator;

import model.Resource;

public abstract class CarDecorator extends Resource {

    protected final Resource resource;

    public CarDecorator(Resource resource) {
        this.resource = resource;
        this.addObservers(resource.getObservers());
        this.setChanged();
    }

    @Override
    public abstract double getPrice();

    @Override
    public String getDescription() {
        return this.resource.getDescription() + "\n+ " + this.getName();
    }

    public abstract String getName();
}
