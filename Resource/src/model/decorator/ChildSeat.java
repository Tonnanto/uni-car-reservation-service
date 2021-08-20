package model.decorator;

import model.Currency;
import model.CurrencyAmount;
import model.Resource;

public class ChildSeat extends CarDecorator {
    public ChildSeat(Resource resource) {
        super(resource);
    }

    @Override
    public CurrencyAmount getPrice() {
        return this.resource.getPrice().add(new CurrencyAmount(30, Currency.US_DOLLAR));
    }

    @Override
    public String getName() {
        return CarDecoratorType.CHILD_SEAT.getName();
    }
}
