package controller;

import model.*;

public class PaymentService {

    /**
     * UseCase: "payAmount"
     * Handles the payment procedure between a customer and the Car Reservation Service GmbH.
     * After selecting a payment type of choice the payment procedure consists of 3 main steps:
     *
     * 1. authenticate customer with payment provider
     * 2. make the transfer from the customer's to the company's account
     * 3. create a payment confirmation and show it to the user
     *
     * @param amount the CurrencyAmount that is being payed
     * @return whether the payment was successful
     */
    public boolean payAmount(CurrencyAmount amount) {

        if (amount.getAmount() <= 0) {
            // TODO: Show appropriate Error Message
            return false;
        }

        PaymentType paymentType = null;
        Payment payment = null;

        // TODO: Prompt customer to choose PaymentType

        if (paymentType == null) {
            // TODO: Show appropriate Error Message
            return false;
        }

        // create payment
        payment = switch (paymentType) {
            case PAYPAL -> new PayPalPayment(amount);
            case GOOGLE_WALLET -> new GoogleWalletPayment(amount);
            case MONEY_WALLET -> new MoneyWalletPayment(amount);
        };
        payment.setReceiverAccount(getReceiverAccount());

        // TODO: Prompt customer to enter credentials for PaymentType
        String userName = "";
        String password = "";

        // 1. authorize customer
        boolean isUserAuthorized = payment.authorizeCustomer(userName, password);

        // TODO: Show user authorization status
        // TODO: (maybe) prompt final payment confirmation from user

        // 2. pay amount
        boolean isAmountPayed = payment.payAmount();

        // 3. create confirmation
        String confirmation = payment.createConfirmation(isAmountPayed);

        // TODO: Show confirmation to customer

        return isAmountPayed;
    }

    /**
     * Gets the account of the Car Reservation Service GmbH.
     * @return the default receiver account
     */
    private Account getReceiverAccount() {
        String ownerName = "Car Reservation Service GmbH";
        String address = "carreservation@service.de";
        return new Account(ownerName, address);
    }

}
