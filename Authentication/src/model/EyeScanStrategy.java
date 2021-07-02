package model;

import controller.AuthenticationService;

public class EyeScanStrategy extends Credential {
    public EyeScanStrategy(AuthenticationService authenticationService) {
        super(authenticationService);
    }

    @Override
    public boolean authenticate(Subject subject) {
        return true;
    }
}
