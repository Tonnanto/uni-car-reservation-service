package model.decorator;

import model.Currency;
import model.CurrencyAmount;
import model.Resource;

public class AmbienceLighting extends CarDecorator{
    public AmbienceLighting(Resource resource) { super(resource);}
    @Override
    public CurrencyAmount getPrice() {
        return this.resource.getPrice().add(new CurrencyAmount(790, Currency.US_DOLLAR));
    }

    @Override
    public String getName() {
        return CarDecoratorType.AMBIENCE_LIGHTING.getName();
    }
}
