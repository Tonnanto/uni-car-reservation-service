package view;

import controller.Config;
import controller.ResourceService;

public class ShowSelectedResourceView extends View {

    private final ResourceService resourceService;

    public ShowSelectedResourceView(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @Override
    protected String getMessage() {
        return Config.resourceBundle.getString("resource.ShowSelectedResourceView.Message") + "\n" + resourceService.getResource().getDescription() + "\n\n= Total: " + resourceService.getResource().getPrice();
    }
}
