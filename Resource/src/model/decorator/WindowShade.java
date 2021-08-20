package model.decorator;

import model.Currency;
import model.CurrencyAmount;
import model.Resource;

public class WindowShade extends CarDecorator{
    public WindowShade(Resource resource) { super(resource);}
    @Override
    public CurrencyAmount getPrice() {
        return this.resource.getPrice().add(new CurrencyAmount(5, Currency.US_DOLLAR));
    }

    @Override
    public String getName() {
        return CarDecoratorType.WINDOW_SHADE.getName();
    }
}