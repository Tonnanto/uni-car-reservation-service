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

    // TODO: Should accounts have a balance attribute and a transfer method?
    // TODO: So we can simulate the transfer and show account balances in the confirmation?
}
