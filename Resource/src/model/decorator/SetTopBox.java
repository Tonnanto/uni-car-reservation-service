package model.decorator;

import model.Resource;

public class SetTopBox extends CarDecorator {
    public SetTopBox(Resource resource) {
        super(resource);
    }

    @Override
    public double getPrice() {
        return this.resource.getPrice() + 80.0;
    }

    @Override
    public String getDescription() {
        return this.resource.getDescription() + "\n+ Set-Top-Box";
    }
}