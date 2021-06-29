package model;

import controller.Observable;

public abstract class Payment extends Observable {

    private Account senderAccount;
    private Account receiverAccount;
    private final CurrencyAmount currencyAmount;

    public Payment(CurrencyAmount amount) {
        this.currencyAmount = amount;
    }

    /**
     * Simulates the authorization at an arbitrary payment provider.
     * Succeeds all the time. Credentials don't actually matter.
     *
     * @param username the username entered by the customer
     * @param password the password entered by the customer
     * @return whether the authorization was successfully simulated (true)
     */
    public boolean authenticateCustomer(String username, String password) {
        boolean authenticated = !username.equals(password); // Purpose: Being able to simulate an unsuccessful authentication

        if (authenticated) {
            //TODO: Use details from customer
            this.senderAccount = new Account(username, username + "@mail.com");
        }

        return authenticated;
    }

    public abstract boolean payAmount();

    public String createConfirmation(boolean success) {
        if (success) {
            String message = getPaymentType() + " Payment successful!";
            message += String.format("\n%s has been transferred from %s to %s.", currencyAmount, senderAccount.getAddress(), receiverAccount.getAddress());
            return message;
        }
        else
            return getPaymentType() + " Payment unsuccessful!";
    }

    public abstract PaymentType getPaymentType();

    public Account getSender() {
        return senderAccount;
    }

    public Account getReceiver() {
        return receiverAccount;
    }

    public void setReceiverAccount(Account receiverAccount) {
        this.receiverAccount = receiverAccount;
    }
}
