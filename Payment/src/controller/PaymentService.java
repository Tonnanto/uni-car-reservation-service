package controller;

import model.*;
import view.*;

public class PaymentService {

    protected String email;
    protected String password;
    protected CurrencyAmount currencyAmount;
    private Payment payment;
    private boolean userAuthenticated;
    private boolean amountPayed;

    /**
     * UseCase: "payAmount"
     * Handles the payment procedure between a customer and the Car Reservation Service GmbH.
     * After selecting a payment type of choice the payment procedure consists of 3 main steps:
     * <p>
     * 1. authenticate customer with payment provider
     * 2. make the transfer from the customer's to the company's account
     * 3. create a payment confirmation and show it to the user
     *
     * @param amount the model.CurrencyAmount that is being payed
     * @return whether the payment was successful
     */
    public Payment payAmount(CurrencyAmount amount) {
        this.currencyAmount = amount;

        if (amount.getAmount() <= 0) {
            System.out.println(Config.resourceBundle.getString("payment.controller.PaymentService"));
            return null;
        }

        while (!amountPayed || payment == null) {
            if (payment == null) {
                new ShowPaymentDetailsView(this).display();
                new SelectPaymentTypeView(this).display();
                continue;
            }

            // PaymentType is selected
            if (!userAuthenticated) {
                if (email == null || email.isEmpty()) {
                    new EnterPaymentEmailView(this).display();
                    continue;
                }
                if (password == null || password.isEmpty()) {
                    new EnterPaymentPasswordView(this).display();
                    continue;
                }
                password = null; // if this line is being reached the user should be prompted to re-enter his password next
            }

            // User is authenticated to the payment provider
            new ShowPaymentDetailsView(this).display();
            new ConfirmPaymentView(this).display();
        }

        new ShowPaymentConfirmationView(this).display();

        return payment;
    }


    //================================================================================
    // Accessors
    //================================================================================

    /**
     * Gets the account of the Car Reservation Service GmbH.
     *
     * @return the default receiver account
     */
    private Account getReceiverAccount() {
        String address = "carreservation@service.de";
        return new Account(address);
    }

    public Payment getPayment() {
        return payment;
    }

    public CurrencyAmount getCurrencyAmount() {
        return currencyAmount;
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
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {

        userAuthenticated = this.payment.authenticateCustomer(email, password);

        new ShowAuthenticationStatusView(this).display();

        if (userAuthenticated)
            this.password = password;
    }

    public void confirmPayment() {
        if (payment == null || !userAuthenticated) return;
        amountPayed = payment.payAmount();
    }

    public void cancelPayment() {
        payment = null;
        email = null;
        password = null;
        userAuthenticated = false;
    }
}
