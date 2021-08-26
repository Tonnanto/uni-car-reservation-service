package view;

import controller.Config;

public class ContentNotFoundView extends View {
    @Override
    protected String getMessage() {
        return Config.resourceBundle.getString("content.view.ContentNotFoundView.Message");
    }
}
