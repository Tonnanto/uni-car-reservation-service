package model.decorator;

import model.Currency;
import model.CurrencyAmount;

public enum CarDecoratorType {
    SET_TOP_BOX, CHILD_SEAT, AMBIENCE_LIGHTING, MAGIC_TREE, WINDOW_SHADE;

    public String getName() {
        return switch (this) {
            case SET_TOP_BOX -> "Set-Top-Box";
            case CHILD_SEAT -> "Child Seat";
            case AMBIENCE_LIGHTING -> "Ambience Lighting";
            case MAGIC_TREE -> "Magic Tree";
            case WINDOW_SHADE -> "Window Shade";
        };
    }

    public boolean canBeAddedMoreThanOnce() {
        return switch (this) {
            case SET_TOP_BOX, AMBIENCE_LIGHTING, WINDOW_SHADE -> false;
            case CHILD_SEAT, MAGIC_TREE -> true;
        };
    }

    public CurrencyAmount getPrice() {
        return switch (this) {
            case SET_TOP_BOX -> new CurrencyAmount(80, Currency.US_DOLLAR);
            case CHILD_SEAT -> new CurrencyAmount(30, Currency.US_DOLLAR);
            case AMBIENCE_LIGHTING -> new CurrencyAmount(790, Currency.US_DOLLAR);
            case MAGIC_TREE -> new CurrencyAmount(2, Currency.US_DOLLAR);
            case WINDOW_SHADE -> new CurrencyAmount(5, Currency.US_DOLLAR);
        };
    }

    public String getDescription() {
        // TODO: Adjust Currency to user settings
        return String.format("%-30s %12s", this.getName(), this.getPrice());
    }
}
