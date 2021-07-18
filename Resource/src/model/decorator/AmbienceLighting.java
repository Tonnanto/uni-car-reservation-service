package model.decorator;

import model.Resource;

public class AmbienceLighting extends CarDecorator{
    public AmbienceLighting(Resource resource) { super(resource);}
    @Override
    public double getPrice() { return this.resource.getPrice() + 790; }

    @Override
    public String getName() {return CarDecoratorType.AMBIENCE_LIGHTING.getName(); }
}
