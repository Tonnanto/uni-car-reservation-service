package controller;

import controller.commands.AddDecoratorCommand;
import controller.commands.FinishResourceSelectionCommand;
import controller.commands.ResetResourceSelectionCommand;
import controller.commands.SelectCarCommand;
import model.Car;
import model.Currency;
import model.CurrencyAmount;
import model.Resource;
import model.decorator.CarDecoratorType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ResourceServiceTest {

    private static ResourceService resourceService;

    @BeforeAll
    static void setUp() {
        resourceService = new ResourceService();
    }

    @Test
    protected void canResourceBeSelected() {
        // Selection and reset
        canCarBeSelected();
        canDecoratorsBeAdded();
        canSelectionBeReset();

        // Selection can not be finished, if no resource is selected.
        canSelectionBeFinished();

        // Standard selection procedure
        canCarBeSelected();
        canDecoratorsBeAdded();
        canSelectionBeFinished();
    }

    protected void canCarBeSelected() {
        Car car = new Car("Audi", new CurrencyAmount(35000, Currency.US_DOLLAR));
        new SelectCarCommand(resourceService, car).execute();

        Resource selectedResource = resourceService.getResource();
        Assertions.assertNotNull(selectedResource);
        Assertions.assertEquals(selectedResource, car);
    }

    protected void canDecoratorsBeAdded() {
        new AddDecoratorCommand(resourceService, CarDecoratorType.CHILD_SEAT).execute();
        new AddDecoratorCommand(resourceService, CarDecoratorType.CHILD_SEAT).execute();
        new AddDecoratorCommand(resourceService, CarDecoratorType.SET_TOP_BOX).execute();

        Resource selectedResource = resourceService.getResource();
        Assertions.assertNotNull(selectedResource);
        Assertions.assertEquals(35140.0, selectedResource.getPrice());
    }

    protected void canSelectionBeReset() {
        Assertions.assertNotNull(resourceService.getResource());
        new ResetResourceSelectionCommand(resourceService).execute();
        Assertions.assertNull(resourceService.getResource());
    }

    protected void canSelectionBeFinished() {
        Assertions.assertFalse(resourceService.isResourceSelected());

        new FinishResourceSelectionCommand(resourceService).execute();

        if (resourceService.getResource() != null) {
            Assertions.assertTrue(resourceService.isResourceSelected());
        } else {
            Assertions.assertFalse(resourceService.isResourceSelected());
        }
    }
}
