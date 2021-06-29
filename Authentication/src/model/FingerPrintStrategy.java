package model;

import controller.AuthenticationService;

public class FingerPrintStrategy extends Credential{
    public FingerPrintStrategy(AuthenticationService authenticationService) {
        super(authenticationService);
    }

    @Override
    public boolean authenticate(Subject subject) {
        return true;
    }
}
