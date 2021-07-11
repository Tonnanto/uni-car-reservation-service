package model;

import controller.AuthenticationService;

public class EyeScanStrategy extends Credential {

    @Override
    public boolean authenticate(Subject subject) {
        return true;
    }

    @Override
    public String getDescription() {
        return "Eye Scan";
    }
}
