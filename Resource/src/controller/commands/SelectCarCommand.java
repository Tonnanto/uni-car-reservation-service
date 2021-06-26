package controller.commands;

import controller.ResourceService;
import model.Car;

public class SelectCarCommand extends ResourceServiceCommand {

    private final Car car;

    public SelectCarCommand(ResourceService receiver, Car car) {
        super(receiver);
        this.car = car;
    }

    @Override
    public void execute() {
        receiver.selectCar(car);
    }

    @Override
    public String getDescription() {
        return car.getDescription();
    }
}
