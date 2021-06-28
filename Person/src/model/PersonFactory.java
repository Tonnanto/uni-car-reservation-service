package model;

public class PersonFactory {

    private static int personCount = 0;

    public Person createPerson(PersonType personType) {
        return switch (personType) {
            case NATURAL_PERSON -> new NaturalPerson(++personCount);
            case LEGAL_PERSON -> new LegalPerson(++personCount);
        };
    }

    public static int getPersonCount() {
        return personCount;
    }
}