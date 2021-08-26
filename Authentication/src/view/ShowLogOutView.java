package view;

import controller.Config;

public class ShowLogOutView extends View {
    @Override
    protected String getMessage() {
        return Config.resourceBundle.getString("authentication.view.ShowLogOutView.Message");
    }
}
