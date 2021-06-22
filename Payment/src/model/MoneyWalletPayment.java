package model;

public class MoneyWalletPayment extends Payment {

    public MoneyWalletPayment(CurrencyAmount amount) {
        super(amount);
    }

    @Override
    public boolean payAmount() {
        return false;
    }
}
