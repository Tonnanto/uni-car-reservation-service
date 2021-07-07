package model;

public enum PaymentType {
    PAYPAL, GOOGLE_WALLET, MONEY_WALLET;

    @Override
    public String toString() {
        return switch (this) {
            case PAYPAL -> "PayPal";
            case GOOGLE_WALLET -> "Google Pay";
            case MONEY_WALLET -> "Mobile Money Wallet";
        };
    }
}
