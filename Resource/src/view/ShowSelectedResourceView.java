package view;

import controller.ResourceService;

public class ShowSelectedResourceView extends View {

    private final ResourceService resourceService;

    public ShowSelectedResourceView(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @Override
    protected String getMessage() {
        return "Your selected resource:\n" + resourceService.getResource().getDescription();
    }
}
