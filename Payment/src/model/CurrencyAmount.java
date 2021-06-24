package model;

public class CurrencyAmount {
    private final Currency currency;
    private final double amount;

    public CurrencyAmount(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }
}
