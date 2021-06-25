package model;

public class Car extends Resource {

    private final String name;
    private final double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getDescription() {
        return this.name;
    }
}
