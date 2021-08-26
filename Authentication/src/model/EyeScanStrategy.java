package model;

import controller.Config;

public class EyeScanStrategy extends Credential {

    @Override
    public boolean authenticate(Subject subject) {
        return true;
    }

    @Override
    public String getDescription() {
        return Config.resourceBundle.getString("authentication.model.EyeScanStrategy.Description");
    }
}
