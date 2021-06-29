package model;

public class GoogleWalletPayment extends Payment {

    public GoogleWalletPayment(CurrencyAmount amount) {
        super(amount);
    }

    @Override
    public boolean payAmount() {
        return true;
    }

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.GOOGLE_WALLET;
    }
}
