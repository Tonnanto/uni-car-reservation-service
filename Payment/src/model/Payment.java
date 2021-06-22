package model;

public abstract class Payment {

    private Account senderAccount;
    private Account receiverAccount;
    private CurrencyAmount amount;

    public Payment(CurrencyAmount amount) {
        this.amount = amount;
    }

    public boolean authorizeCustomer(String userName, String password) {
        boolean authorized = true;

        if (authorized)
            this.senderAccount = new Account("Customer", "customer address"); //TODO: Use details from customer

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
