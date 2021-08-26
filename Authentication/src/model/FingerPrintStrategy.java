package model;

import controller.Config;

public class FingerPrintStrategy extends Credential {

    @Override
    public boolean authenticate(Subject subject) {
        return true;
    }

    @Override
    public String getDescription() {
        return Config.resourceBundle.getString("authentication.model.FingerPrintStrategy.Description");
    }
}
