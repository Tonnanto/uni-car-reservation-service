package model.decorator;

import model.CurrencyAmount;
import model.Resource;

public abstract class CarDecorator extends Resource {

    protected final Resource resource;

    public CarDecorator(Resource resource) {
        this.resource = resource;
    }

    @Override
    public CurrencyAmount getPrice() {
        return this.resource.getPrice().add(getDecoratorType().getPrice());
    }

    @Override
    public String getDescription() {
        return this.resource.getDescription() + "\n+ " + getDecoratorType().getDescription();
    }

    @SuppressWarnings("unused")
    public abstract String getName();

    public Resource getResource() {
        return resource;
    }

    public abstract CarDecoratorType getDecoratorType();
}
