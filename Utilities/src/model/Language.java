package model;

import controller.Config;

public enum Language {
    GERMAN, ENGLISH;

    @Override
    public String toString() {
        return switch (this) {
            case GERMAN -> Config.resourceBundle.getString("utilities.model.Language.german");
            case ENGLISH -> Config.resourceBundle.getString("utilities.model.Language.english");
        };
    }

    public String countryCode() {
        return switch (this) {
            case GERMAN -> "de";
            case ENGLISH -> "en";
        };
    }
}
