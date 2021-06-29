package model;

import controller.AuthenticationService;

public class UserNamePasswordStrategy extends Credential{

    private String username;
    private String password;

    public UserNamePasswordStrategy(AuthenticationService authenticationService) {
        super(authenticationService);
    }

    @Override
    public boolean authenticate(Subject subject) {
        return true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        this.setChanged();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        this.setChanged();
    }
}
