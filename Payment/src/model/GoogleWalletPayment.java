package model;

public class GoogleWalletPayment extends Payment {

    public GoogleWalletPayment(CurrencyAmount amount) {
        super(amount);
    }

    @Override
    public boolean payAmount() {
        return true;
    }
}
