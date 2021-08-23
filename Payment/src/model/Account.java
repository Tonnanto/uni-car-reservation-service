package model;

/**
 * This class represents an account at a given payment provider
 */
public class Account {
    private final String email;

    public Account(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
