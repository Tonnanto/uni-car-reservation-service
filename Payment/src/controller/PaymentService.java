package controller;

import model.*;

public class PaymentService {

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

    private Account getReceiverAccount() {
        String ownerName = "Car Reservation Service GmbH";
        String address = "carreservation@service.de";
        return new Account(ownerName, address);
    }

}
