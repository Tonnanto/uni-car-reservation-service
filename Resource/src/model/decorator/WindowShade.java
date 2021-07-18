package model.decorator;

import model.Resource;

public class WindowShade extends CarDecorator{
    public WindowShade(Resource resource) { super(resource);}
    @Override
    public double getPrice() { return this.resource.getPrice() + 5; }

    @Override
    public String getName() {return CarDecoratorType.WINDOW_SHADE.getName(); }
}