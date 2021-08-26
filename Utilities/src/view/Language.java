package view;

public enum Language {
    GERMAN, ENGLISH;

    @Override
    public String toString() {
        return switch (this) {
            case GERMAN -> "German";
            case ENGLISH -> "English";
        };
    }

    public String countryCode() {
        return switch (this) {
            case GERMAN -> "de";
            case ENGLISH -> "en";
        };
    }
}
