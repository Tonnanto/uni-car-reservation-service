package model.decorator;

import model.CurrencyAmount;
import model.Resource;

public abstract class CarDecorator extends Resource {

    protected final Resource resource;

    public CarDecorator(Resource resource) {
        this.resource = resource;
    }

    @Override
    public abstract CurrencyAmount getPrice();

    @Override
    public String getDescription() {
        return this.resource.getDescription() + "\n+ " + this.getName();
    }

    public abstract String getName();

    public Resource getResource() {
        return resource;
    }
}
