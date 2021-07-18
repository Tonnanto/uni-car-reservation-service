package model.decorator;

import model.Resource;

public class MagicTree extends CarDecorator{
    public MagicTree(Resource resource) { super(resource);}

    @Override
    public double getPrice() { return this.resource.getPrice() + 2; }

    @Override
    public String getName() {return CarDecoratorType.MAGIC_TREE.getName(); }
}