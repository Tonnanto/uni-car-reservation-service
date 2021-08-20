package model.decorator;

import model.Currency;
import model.CurrencyAmount;
import model.Resource;

public class SetTopBox extends CarDecorator {
    public SetTopBox(Resource resource) {
        super(resource);
    }

    @Override
    public CurrencyAmount getPrice() {
        return this.resource.getPrice().add(new CurrencyAmount(80, Currency.US_DOLLAR));
    }

    @Override
    public String getName() {
        return CarDecoratorType.SET_TOP_BOX.getName();
    }
}
