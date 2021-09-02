package model;

import controller.Config;

public enum PersonType {
    NATURAL_PERSON,
    LEGAL_PERSON;
    //TODO Localisation?
    @Override
    public String toString() {
        return switch (this) {
            case NATURAL_PERSON -> Config.resourceBundle.getString("person.model.PersonType.String1");
            case LEGAL_PERSON -> Config.resourceBundle.getString("person.model.PersonType.String2");
        };
    }
}

