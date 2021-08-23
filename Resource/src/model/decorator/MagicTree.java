package model.decorator;

import model.Resource;

public class MagicTree extends CarDecorator {
    public MagicTree(Resource resource) {
        super(resource);
    }

    @Override
    public String getName() {
        return CarDecoratorType.MAGIC_TREE.getName();
    }

    @Override
    public CarDecoratorType getDecoratorType() {
        return CarDecoratorType.MAGIC_TREE;
    }
}