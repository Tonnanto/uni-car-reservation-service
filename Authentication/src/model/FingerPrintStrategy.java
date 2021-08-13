package model;

import controller.AuthenticationService;
import view.Language;

public class FingerPrintStrategy extends Credential {

    @Override
    public boolean authenticate(Subject subject) {
        return true;
    }

    @Override
    public String getDescription() {
        return Language.resourceBundle.getString("authentication.model.FingerPrintStrategy.Description");
    }
}
