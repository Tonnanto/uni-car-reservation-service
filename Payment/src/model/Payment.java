package model;

import controller.Config;

@SuppressWarnings("SameReturnValue")
public abstract class Payment {

    private final CurrencyAmount currencyAmount;
    private Account senderAccount;
    private Account receiverAccount;

    public Payment(CurrencyAmount amount) {
        this.currencyAmount = amount;
    }

    /**
     * Simulates the authorization at an arbitrary payment provider.
     * Succeeds all the time. Credentials don't actually matter.
     *
     * @param email    the email entered by the customer
     * @param password the password entered by the customer
     * @return whether the authorization was successfully simulated (true)
     */
    public boolean authenticateCustomer(String email, String password) {
        if (email == null || password == null) return false;

        boolean authenticated = !email.equals(password); // Purpose: Being able to simulate an unsuccessful authentication

        if (authenticated)
            this.senderAccount = new Account(email);

        return authenticated;
    }

    @SuppressWarnings("SameReturnValue")
    public abstract boolean payAmount();

    public String createConfirmation(boolean success) {
        if (success) {
            String message = getPaymentType() + " Payment successful!";
            message += String.format("\n%s has been transferred from %s to %s.", currencyAmount, senderAccount.getEmail(), receiverAccount.getEmail());
            return message;
        } else
            return getPaymentType() + " " + Config.resourceBundle.getString("payment.model.Payment.getPaymentType2");
    }

    public abstract PaymentType getPaymentType();

    public Account getSender() {
        return senderAccount;
    }

    public Account getReceiver() {
        return receiverAccount;
    }

    public CurrencyAmount getCurrencyAmount() {
        return currencyAmount;
    }

    public void setReceiverAccount(Account receiverAccount) {
        this.receiverAccount = receiverAccount;
    }
}
