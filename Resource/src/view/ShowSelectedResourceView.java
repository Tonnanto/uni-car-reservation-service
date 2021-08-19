package view;

import controller.ResourceService;

public class ShowSelectedResourceView extends View {

    private final ResourceService resourceService;

    public ShowSelectedResourceView(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @Override
    protected String getMessage() {
        return Language.resourceBundle.getString("resource.ShowSelectedResourceView.Message")+ "\n" + resourceService.getResource().getDescription();
    }
}
