package view;

import controller.AuthenticationService;

public class ShowLoginStatusView extends View {

    public final AuthenticationService authenticationService;

    public ShowLoginStatusView(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    protected String getMessage() {
        if (authenticationService.isSubjectAuthenticated())
            return Language.resourceBundle.getString("authentication.view.ShowLogInStatusView.Message1");
        else return Language.resourceBundle.getString("authentication.view.ShowLogInStatusView.Message2");
    }
}
