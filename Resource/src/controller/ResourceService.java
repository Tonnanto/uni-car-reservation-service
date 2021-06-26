package controller;

import model.Car;
import model.Resource;
import model.decorator.CarDecoratorType;
import model.decorator.ChildSeat;
import model.decorator.SetTopBox;
import view.AddCarDecoratorView;
import view.SelectCarView;
import view.ShowSelectedResourceView;

import java.util.Arrays;
import java.util.List;

/**
 * Manages the selection process and the creation of a resource (car).
 */
public class ResourceService implements Observer {

    private final List<Car> availableCars;
    private boolean isResourceSelected;
    private Resource resource;

    public ResourceService() {
        this.availableCars = Arrays.asList(
                new Car("BMW 530d Touring", 49900),
                new Car("Volkswagen Golf", 24000)
        );
    }

    // TODO: temporary method
    public static void main(String[] args) {
        ResourceService resourceService = new ResourceService();
        resourceService.getSelectedResource();
    }

    /**
     * Creates and returns a resource according to the selections of a user.
     * @return the selected resource
     */
    public Resource getSelectedResource() {

        while (!isResourceSelected) {
            if (resource == null) {
                // select a car
                new SelectCarView(this).display();

            } else {
                // add decorator
                new AddCarDecoratorView(this).display();
            }
        }

        return resource;
    }

    @Override
    public void update(Object object) {
        new ShowSelectedResourceView(this).display();
    }

    public List<Car> getAvailableCars() {
        return availableCars;
    }

    public Resource getResource() {
        return resource;
    }

    public void selectCar(Car car) {
        car.addObserver(this);
        this.resource = car;
        resource.setChanged();
    }

    /**
     * This method is being called, when the user decides to finish the selection.
     */
    public void finishSelection() {
        if (resource == null) return;
        isResourceSelected = true;
    }

    public void addDecorator(CarDecoratorType decoratorType) {
        if (resource == null) return;

        resource = switch (decoratorType) {
            case CHILD_SEAT -> new ChildSeat(resource);
            case SET_TOP_BOX -> new SetTopBox(resource);
        };

        resource.setChanged();
    }

    public void resetSelection() {
        resource = null;
    }
}
