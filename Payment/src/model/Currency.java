package model;

public enum Currency {
    EURO, US_DOLLAR;

    @Override
    public String toString() {
        return switch (this) {
            case EURO -> "€";
            case US_DOLLAR -> "$";
        };
    }

    /**
     * @return The exchange rate of the given currency to USD
     */
    public double inUSD() {
        return switch (this) {
            case EURO -> 1.18;
            case US_DOLLAR -> 1.0;
        };
    }
}
