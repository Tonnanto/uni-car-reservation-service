package model.decorator;

public enum CarDecoratorType {
    SET_TOP_BOX, CHILD_SEAT;

    public String getName() {
        return switch (this) {
            case SET_TOP_BOX -> "Set-Top-Box";
            case CHILD_SEAT -> "Child Seat";
        };
    }
}
