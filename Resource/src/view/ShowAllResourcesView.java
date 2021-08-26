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
                        Config.resourceBundle.getString("resource.view.ShowAllResourcesView.Message1"),
                        Config.resourceBundle.getString("resource.view.ShowAllResourcesView.Message2")
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
                        Config.resourceBundle.getString("resource.view.ShowAllResourcesView.Message3"),
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
