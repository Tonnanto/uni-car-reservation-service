package model;

import java.text.DecimalFormat;

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

    @SuppressWarnings("unused")
    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return String.format("%s%s", currency, new DecimalFormat("#0.00").format(amount));
    }

    /**
     * Converts the model.CurrencyAmount to a different currency
     *
     * @param currency the model.Currency to convert to
     * @return the new model.CurrencyAmount Object
     */
    public CurrencyAmount to(Currency currency) {
        if (this.currency == currency) return new CurrencyAmount(amount, currency);

        return new CurrencyAmount(this.amount * this.currency.inUSD() / currency.inUSD(), currency);
    }

    /**
     * Adds a given currencyAmount to the current one.
     * If necessary converts the given currencyAmount to the currency of the current one first.
     *
     * @param addAmount currencyAmount to add
     * @return a new currencyAmount Object
     */
    public CurrencyAmount add(CurrencyAmount addAmount) {
        return new CurrencyAmount(this.amount + (addAmount.to(this.currency).getAmount()), currency);
    }
}
