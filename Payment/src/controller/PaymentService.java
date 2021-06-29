package controller;

import model.*;
import view.*;

public class PaymentService implements Observer {

    private Payment payment;
    private String username;
    private String password;
    private CurrencyAmount currencyAmount;
    private boolean userAuthenticated;
    private boolean amountPayed;

    // TODO: temporary method
    public static void main(String[] args) {
        new PaymentService().payAmount(new CurrencyAmount(100, Currency.EURO));
    }

    /**
     * UseCase: "payAmount"
     * Handles the payment procedure between a customer and the Car Reservation Service GmbH.
     * After selecting a payment type of choice the payment procedure consists of 3 main steps:
     *
     * // TODO: separate these steps into individual methods
     * 1. authenticate customer with payment provider
     * 2. make the transfer from the customer's to the company's account
     * 3. create a payment confirmation and show it to the user
     *
     * @param amount the CurrencyAmount that is being payed
     * @return whether the payment was successful
     */
    public Payment payAmount(CurrencyAmount amount) {
        this.currencyAmount = amount;

        if (amount.getAmount() <= 0) {
            // TODO: Show appropriate Error Message
            return null;
        }

        new ShowPaymentDetailsView(this).display();

        while (!amountPayed || payment == null) {
            if (payment == null) {
                new SelectPaymentTypeView(this).display();
                continue;
            }

            // PaymentType is selected
            if (!userAuthenticated) {
                if (username == null || username.isEmpty()) {
                    new EnterUsernameView(this).display();
                    continue;
                }
                if (password == null || password.isEmpty()) {
                    new EnterPasswordView(this).display();
                    continue;
                }
                password = null; // if this line is being reached the user should be prompted to re-enter his password next
            }

            // User is authenticated to the payment provider
            new ConfirmPaymentView(this).display();
        }

        new ShowConfirmationView(this).display();

        return payment;
    }

    /**
     * This method being called whenever the associated Observables call .setChanged()
     * @param object the object that changed
     */
    @Override
    public void update(Object object) {
        new ShowPaymentDetailsView(this).display();
    }


    //================================================================================
    // Accessors
    //================================================================================

    /**
     * Gets the account of the Car Reservation Service GmbH.
     * @return the default receiver account
     */
    private Account getReceiverAccount() {
        String ownerName = "Car Reservation Service GmbH";
        String address = "carreservation@service.de";
        return new Account(ownerName, address);
    }

    public Payment getPayment() {
        return payment;
    }

    public CurrencyAmount getCurrencyAmount() {
        return currencyAmount;
    }

    public String getUsername() {
        return username;
    }

    public boolean isUserAuthenticated() {
        return userAuthenticated;
    }

    public boolean isAmountPayed() {
        return amountPayed;
    }

    //================================================================================
    // The following methods are being called by their corresponding commands.
    //================================================================================

    public void selectPaymentType(PaymentType paymentType) {
        switch (paymentType) {
            case PAYPAL -> this.payment = new PayPalPayment(currencyAmount);
            case GOOGLE_WALLET -> this.payment = new GoogleWalletPayment(currencyAmount);
            case MONEY_WALLET -> this.payment = new MoneyWalletPayment(currencyAmount);
        }

        payment.setReceiverAccount(getReceiverAccount());
        payment.addObserver(this);
        payment.setChanged();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {

        userAuthenticated = this.payment.authenticateCustomer(username, password);

        new ShowAuthenticationStatusView(this).display();

        if (userAuthenticated) {
            this.password = password;
            payment.setChanged();
        }
    }

    public void confirmPayment() {
        if (payment == null || !userAuthenticated) return;
        amountPayed = payment.payAmount();

        payment.setChanged();
    }

    public void cancelPayment() {
        payment = null;
        username = null;
        password = null;
        userAuthenticated = false;
    }
}
