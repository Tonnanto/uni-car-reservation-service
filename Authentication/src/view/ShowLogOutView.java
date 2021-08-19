package view;

public class ShowLogOutView extends View {
    @Override
    protected String getMessage() {
        return Language.resourceBundle.getString("authentication.view.ShowLogOutView.Message");
    }
}
