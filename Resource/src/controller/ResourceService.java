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
    private boolean resourceSelected;
    private Resource resource;

    public ResourceService() {
        this.availableCars = Arrays.asList(
                new Car("BMW 530d Touring", 49900),
                new Car("Volkswagen Golf", 24000)
        );
    }

    /**
     * Creates and returns a resource according to the selections of a user.
     * Different Views are being displayed in order to receive user input.
     * @return the selected resource
     */
    public Resource getSelectedResource() {

        while (!resourceSelected) {
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

    /**
     * Is being called whenever the associated Observables call .setChanged()
     * @param object the object that changed
     */
    @Override
    public void update(Object object) {
        new ShowSelectedResourceView(this).display();
    }

    //================================================================================
    // Accessors
    //================================================================================

    public List<Car> getAvailableCars() {
        return availableCars;
    }

    public Resource getResource() {
        return resource;
    }

    public boolean isResourceSelected() {
        return resourceSelected;
    }

    //================================================================================
    // The following methods are being called by their corresponding commands.
    //================================================================================

    public void selectCar(Car car) {
        this.resource = car;

        if (car != null) {
            resource.addObserver(this);
            resource.setChanged();
        }
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

    public void finishSelection() {
        if (resource == null) return;
        resourceSelected = true;
    }
}
