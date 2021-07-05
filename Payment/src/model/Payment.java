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
     * @param email the email entered by the customer
     * @param password the password entered by the customer
     * @return whether the authorization was successfully simulated (true)
     */
    public boolean authenticateCustomer(String email, String password) {
        boolean authenticated = !email.equals(password); // Purpose: Being able to simulate an unsuccessful authentication

        if (authenticated) {
            //TODO: Use details from customer
            this.senderAccount = new Account(email);
        }

        return authenticated;
    }

    public abstract boolean payAmount();

    public String createConfirmation(boolean success) {
        if (success) {
            String message = getPaymentType() + " Payment successful!";
            message += String.format("\n%s has been transferred from %s to %s.", currencyAmount, senderAccount.getEmail(), receiverAccount.getEmail());
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
