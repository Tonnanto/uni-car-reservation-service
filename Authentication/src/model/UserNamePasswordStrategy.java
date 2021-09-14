package model;

import controller.Config;

public class UserNamePasswordStrategy extends Credential {

    private String username;
    private String password;

    @Override
    public boolean authenticate(Subject subject) {
        return username != null && password != null;
    }

    @Override
    public String getDescription() {
        return Config.resourceBundle.getString("authentication.model.UserNamePasswordStrategy.Description");
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
