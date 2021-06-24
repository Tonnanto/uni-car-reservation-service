package model;

public abstract class Payment {

    private Account senderAccount;
    private Account receiverAccount;
    private CurrencyAmount amount;

    public Payment(CurrencyAmount amount) {
        this.amount = amount;
    }

    /**
     * Simulates the authorization at an arbitrary payment provider.
     * Succeeds all the time. Credentials don't actually matter.
     *
     * @param username the username entered by the customer
     * @param password the password entered by the customer
     * @return whether the authorization was successfully simulated (true)
     */
    public boolean authorizeCustomer(String username, String password) {
        boolean authorized = true;

        if (authorized) {
            //TODO: Use details from customer
            this.senderAccount = new Account(username, username + "@gibmirgeld.de");
        }

        return authorized;
    }

    public abstract boolean payAmount();

    public String createConfirmation(boolean success) {
        // TODO: Edit Confirmation Messages
        if (success)
            return "Success";
        else
            return "No Success";
    }

    public void setReceiverAccount(Account receiverAccount) {
        this.receiverAccount = receiverAccount;
    }
}
