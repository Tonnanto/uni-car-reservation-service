package model;

import model.decorator.CarDecorator;

import model.decorator.*;

public abstract class Resource {
    public abstract CurrencyAmount getPrice();
    public abstract String getDescription();

    public boolean containsDecoratorType(CarDecoratorType carDecoratorType) {
        if (this instanceof CarDecorator) {
            CarDecorator carDecorator = (CarDecorator) this;

            // Checks if this object is of the given CarDecoratorType
            if (carDecoratorType == carDecorator.getDecoratorType()) return true;

            // Checks if the wrapped resource is of the given CarDecoratorType
            return carDecorator.getResource().containsDecoratorType(carDecoratorType);
        }
        return false;
    }
}
