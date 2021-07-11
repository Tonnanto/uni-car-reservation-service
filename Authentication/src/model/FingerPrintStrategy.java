package model;

import controller.AuthenticationService;

public class FingerPrintStrategy extends Credential {

    @Override
    public boolean authenticate(Subject subject) {
        return true;
    }

    @Override
    public String getDescription() {
        return "Finger Scan";
    }
}
