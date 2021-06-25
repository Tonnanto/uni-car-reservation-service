package controller.commands;

import model.Car;

public class SelectCarCommand extends ResourceServiceCommand {

    private final Car car;

    public SelectCarCommand(Car car) {
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
