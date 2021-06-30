package view;

import controller.AuthenticationService;

public class ShowLoginStatusView extends View{

    public final AuthenticationService authenticationService;

    public ShowLoginStatusView(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    protected String getMessage() {
        if (authenticationService.isSubjectAuthenticated())
        return "You are successfully logged in!";
        else return "You are not logged in!";
    }
}
