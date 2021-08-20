package view;

import controller.ResourceService;
import model.Car;
import model.decorator.CarDecoratorType;

public class ShowAllResourcesView extends View {

    private final ResourceService resourceService;

    public ShowAllResourcesView(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @Override
    protected String getMessage() {
        StringBuilder text = new StringBuilder("Cars: \n");
        for (Car car : resourceService.getAvailableCars()) {
            text.append(car.getDescription()).append("\n");
        }
        text.append("""
                ~~~~~~~~~~~~~~~~~~~~~~~~~~\s
                Decorators:
                """);
        for (CarDecoratorType carDecoratorType : CarDecoratorType.values()) {
            text.append(carDecoratorType.getDescription()).append("\n");
        }
        return text.toString();
    }
}
