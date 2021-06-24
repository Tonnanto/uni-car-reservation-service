package model;

/**
 * This class represents an account at a given payment provider
 */
public class Account {
    private String ownerName;
    private String address;

    public Account(String ownerName, String address) {
        this.ownerName = ownerName;
        this.address = address;
    }
}
