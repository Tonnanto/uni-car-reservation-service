package model;

import controller.Config;

public class Car extends Resource {

    private final String name;
    private final CurrencyAmount price;

    public Car(String name, CurrencyAmount price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public CurrencyAmount getPrice() {
        return this.price;
    }

    @Override
    public String getDescription() {
        return String.format("%-32s %12s", name, price.to(Config.currency));
    }
}
