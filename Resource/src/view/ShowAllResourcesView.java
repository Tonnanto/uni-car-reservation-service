package view;

import controller.Config;
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
        StringBuilder sb = new StringBuilder();

        sb.append("\n");
        sb.append(String.format("┌───────────────────────────────────┬──────────────┐%n"));
        sb.append(
                String.format(
                        "│ %-33s │ %12s │%n",
                        "Cars",
                        "Price"
                )
        );
        sb.append(String.format("├───────────────────────────────────┼──────────────┤%n"));

        for (Car car : resourceService.getAvailableCars()) {
            sb.append(
                    String.format(
                            "│ %-33s │ %12s │%n",
                            car.getName(),
                            car.getPrice().to(Config.currency)
                    )
            );
        }

        sb.append(String.format("├───────────────────────────────────┼──────────────┤%n"));
        sb.append(
                String.format(
                        "│ %-33s │ %12s │%n",
                        "Add-Ons",
                        ""
                )
        );
        sb.append(String.format("├───────────────────────────────────┼──────────────┤%n"));

        for (CarDecoratorType carDecoratorType : CarDecoratorType.values()) {
            sb.append(
                    String.format(
                            "│ %-33s │ %12s │%n",
                            carDecoratorType.getName(),
                            carDecoratorType.getPrice().to(Config.currency)
                    )
            );
        }

        sb.append(String.format("└───────────────────────────────────┴──────────────┘%n"));

        return sb.toString();
    }
}
