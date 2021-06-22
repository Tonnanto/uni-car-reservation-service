package controller;

import model.LegalPerson;
import model.NaturalPerson;
import model.Person;
import model.PersonType;

public class PersonService {

    private static int personCount = 0;

    public Person createPerson(PersonType personType) {

        String name = "Name";
        //TODO prompt user to enter name

        return switch (personType) {
            case NATURAL_PERSON -> new NaturalPerson(name, ++personCount);
            case LEGAL_PERSON -> new LegalPerson(name, ++personCount);
        };

    }

    public static int getPersonCount() {
        return personCount;
    }
}