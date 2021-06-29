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
}
