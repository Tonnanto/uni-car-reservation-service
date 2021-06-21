package controller;

import model.Car;
import model.Resource;
import model.decorator.ChildSeat;
import model.decorator.SetTopBox;

/**
 * Manages the selection process and the creation of a resource (car).
 */
public class ResourceService {

    /**
     * Creates and returns a resource according to the selections of a user.
     * // TODO: The selection procedure is yet to be implemented in a view.
     * @return the selected resource
     */
    public Resource getSelectedResource() {

        Car car;
        // TODO: Let User Select Car and Decorators

        // temporary
        car = new Car("BMW 530d Touring", 49900);
        Resource selectedResource = new SetTopBox( new ChildSeat(car));

        return selectedResource;
    }
}
