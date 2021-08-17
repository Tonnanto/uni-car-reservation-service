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

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return String.format("%s%s", currency, new DecimalFormat("#0.00").format(amount));
    }

    /**
     * Converts the CurrencyAmount to a different currency
     * @param currency the Currency to convert to
     * @return the new CurrencyAmount Object
     */
    public CurrencyAmount to(Currency currency) {
        if (this.currency == currency) return new CurrencyAmount(amount, currency);

        return new CurrencyAmount(this.amount / this.currency.inUSD() * currency.inUSD(), currency);
    }
}
