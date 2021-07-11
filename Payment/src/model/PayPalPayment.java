package model;

public class PayPalPayment extends Payment {

    public PayPalPayment(CurrencyAmount amount) {
        super(amount);
    }

    @Override
    public boolean payAmount() {
        return true;
    }

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.PAYPAL;
    }
}
