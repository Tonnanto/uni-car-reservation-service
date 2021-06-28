package model;

public class UserNamePasswordStrategy implements Credential{

    private String username;
    private String password;

    @Override
    public boolean authenticate(Subject subject) {
        return true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
