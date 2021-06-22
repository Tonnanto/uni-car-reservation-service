package controller;

import model.Car;
import model.Resource;
import model.decorator.ChildSeat;
import model.decorator.SetTopBox;
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

        //TODO: adjust this test when the selection procedure is implemented (view)
        Resource selectedResource = resourceService.getSelectedResource();
        Assertions.assertEquals(50010.0, selectedResource.getPrice());
    }

    @Test
    protected void canResourceBeCreated() {
        Car car1 = new Car("Mercedes", 50000);
        Assertions.assertEquals(50000, car1.getPrice());
        Assertions.assertEquals(50030, new ChildSeat(car1).getPrice());
        Assertions.assertEquals(50080, new SetTopBox(car1).getPrice());
        Assertions.assertEquals(50110, new ChildSeat(new SetTopBox(car1)).getPrice());
        Assertions.assertEquals(50270, new SetTopBox(new SetTopBox(new ChildSeat(new SetTopBox(car1)))).getPrice());

        Car car2 = new Car("Opel", -500);
        Assertions.assertEquals(-500, car2.getPrice());
        Assertions.assertEquals(-470, new ChildSeat(car2).getPrice());
        Assertions.assertEquals(-420, new SetTopBox(car2).getPrice());
        Assertions.assertEquals(-390, new ChildSeat(new SetTopBox(car2)).getPrice());
        Assertions.assertEquals(-230, new SetTopBox(new SetTopBox(new ChildSeat(new SetTopBox(car2)))).getPrice());
    }
}
