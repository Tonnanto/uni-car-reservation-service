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
            if (carDecoratorType == CarDecoratorType.CHILD_SEAT) {
                if (this instanceof ChildSeat) return true;
            } else if (carDecoratorType == CarDecoratorType.SET_TOP_BOX) {
                if (this instanceof SetTopBox) return true;
            } else if (carDecoratorType == CarDecoratorType.AMBIENCE_LIGHTING) {
                if (this instanceof AmbienceLighting) return true;
            } else if (carDecoratorType == CarDecoratorType.MAGIC_TREE) {
                if (this instanceof MagicTree) return true;
            } else if (carDecoratorType == CarDecoratorType.WINDOW_SHADE) {
                if (this instanceof WindowShade) return true;
            }
            // Checks if the wrapped resource is of the given CarDecoratorType
            return carDecorator.getResource().containsDecoratorType(carDecoratorType);
        }
        return false;
    }
}
