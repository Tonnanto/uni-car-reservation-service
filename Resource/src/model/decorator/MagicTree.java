package model.decorator;

import model.Currency;
import model.CurrencyAmount;
import model.Resource;

public class MagicTree extends CarDecorator{
    public MagicTree(Resource resource) { super(resource);}

    @Override
    public CurrencyAmount getPrice() {
        return this.resource.getPrice().add(new CurrencyAmount(2, Currency.US_DOLLAR));
    }

    @Override
    public String getName() {
        return CarDecoratorType.MAGIC_TREE.getName();
    }
}