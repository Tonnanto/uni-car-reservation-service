package controller;

import model.Car;
import model.Currency;
import model.CurrencyAmount;
import model.Resource;
import model.decorator.*;
import view.AddCarDecoratorView;
import view.SelectCarView;
import view.ShowAllResourcesView;
import view.ShowSelectedResourceView;

import java.util.Arrays;
import java.util.List;

/**
 * Manages the selection process and the creation of a resource (car).
 */
public class ResourceService {

    private final List<Car> availableCars;
    private boolean resourceSelected;
    private Resource resource;

    public ResourceService() {
        this.availableCars = Arrays.asList(
                new Car("BMW 530d Touring", new CurrencyAmount(49900, Currency.US_DOLLAR)),
                new Car("Volkswagen Golf", new CurrencyAmount(24000, Currency.US_DOLLAR)),
                new Car("Opel Corsa", new CurrencyAmount(14600, Currency.US_DOLLAR)),
                new Car("Mercedes Benz C220", new CurrencyAmount(37440, Currency.US_DOLLAR))
        );
    }

    /**
     * Creates and returns a resource according to the selections of a user.
     * Different Views are being displayed in order to receive user input.
     *
     * @return the selected resource
     */
    public Resource getSelectedResource() {

        while (!resourceSelected) {
            if (resource == null) {
                // select a car
                new SelectCarView(this).display();

            } else {
                // show selected resource
                new ShowSelectedResourceView(this).display();

                // add decorator
                new AddCarDecoratorView(this).display();
            }
        }

        return resource;
    }

    public void showAllResources() {
        new ShowAllResourcesView(this).display();
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
    }

    public void addDecorator(CarDecoratorType decoratorType) {
        if (resource == null) return;

        resource = switch (decoratorType) {
            case CHILD_SEAT -> new ChildSeat(resource);
            case SET_TOP_BOX -> new SetTopBox(resource);
            case AMBIENCE_LIGHTING -> new AmbienceLighting(resource);
            case MAGIC_TREE -> new MagicTree(resource);
            case WINDOW_SHADE -> new WindowShade(resource);
        };
    }

    public void resetSelection() {
        resource = null;
    }

    public void finishSelection() {
        if (resource == null) return;
        resourceSelected = true;
    }
}
