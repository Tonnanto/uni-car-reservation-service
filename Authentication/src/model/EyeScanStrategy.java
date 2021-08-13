package model;

import controller.AuthenticationService;
import view.Language;

public class EyeScanStrategy extends Credential {

    @Override
    public boolean authenticate(Subject subject) {
        return true;
    }

    @Override
    public String getDescription() {
        return Language.resourceBundle.getString("authentication.model.EyeScanStrategy.Description");
    }
}
