package view;

import controller.AuthenticationService;
import controller.Config;

public class ShowLoginStatusView extends View {

    public final AuthenticationService authenticationService;

    public ShowLoginStatusView(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    protected String getMessage() {
        if (authenticationService.isSubjectAuthenticated())
            return Config.resourceBundle.getString("authentication.view.ShowLogInStatusView.Message1");
        else return Config.resourceBundle.getString("authentication.view.ShowLogInStatusView.Message2");
    }
}
