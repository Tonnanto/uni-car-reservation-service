package model.decorator;

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
}
