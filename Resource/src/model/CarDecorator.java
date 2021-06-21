package model;

public abstract class CarDecorator implements Resource {

    private final Resource resource;

    public CarDecorator(Resource resource) {
        this.resource = resource;
    }

    @Override
    public double getPrice() {
        double price = 0;
        return this.resource.getPrice() + price;
    }

    @Override
    public String getDescription() {
        String name = "";
        return this.resource.getDescription() + name;
    }
}
