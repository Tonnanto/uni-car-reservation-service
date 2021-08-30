package model;

public enum PersonType {
    NATURAL_PERSON,
    LEGAL_PERSON;
    //TODO Localisation?
    @Override
    public String toString() {
        return switch (this) {
            case NATURAL_PERSON -> "Natural Person";
            case LEGAL_PERSON -> "Legal Person";
        };
    }
}

