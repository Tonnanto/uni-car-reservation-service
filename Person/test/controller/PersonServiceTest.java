package controller;

import controller.commands.*;
import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PersonServiceTest {

    private static PersonService personService;

    @BeforeAll
    protected static void setUp() {
        personService = new PersonService();
    }

    @Test
    protected void canPersonBeCreated() {
        for (PersonType personType : PersonType.values()) {
            // Selection and reset
            canPersonTypeBeSelected(personType);
            canNameBeAdded();
            canEmailBeAdded();
            canSelectionBeReset();

            // Selection can not be finished, if no person is selected.
            canSelectionBeFinished();

            // Standard selection procedure
            canPersonTypeBeSelected(personType);
            canNameBeAdded();
            canEmailBeAdded();
            canSelectionBeFinished();
        }

    }

    protected void canPersonTypeBeSelected(PersonType personType) {
        new SelectPersonTypeCommand(personService, personType).execute();

        Person person = personService.getPerson();
        Assertions.assertNotNull(person);
        if (personType == PersonType.NATURAL_PERSON) {
            Assertions.assertTrue(person instanceof NaturalPerson);
        } else {
            Assertions.assertTrue(person instanceof LegalPerson);
        }


    }

    protected void canNameBeAdded() {
        String name = "Ramazan Kaymaz";
        new SetNameCommand(personService, name).execute();

        Assertions.assertEquals(name, personService.getPerson().getName());

    }

    protected void canEmailBeAdded() {
        String email = "ramo16@gmx.de";
        new SetEmailCommand(personService, email).execute();

        Assertions.assertEquals(email, personService.getPerson().getEmail());
    }

    protected void canSelectionBeReset() {
        Assertions.assertNotNull(personService.getPerson());
        new ResetSelectionCommand(personService).execute();
        Assertions.assertNull(personService.getPerson());
    }

    protected void canSelectionBeFinished() {
        Assertions.assertFalse(personService.isPersonCreated());

        new FinishSelectionCommand(personService).execute();

        if (personService.getPerson() != null) {
            Assertions.assertTrue(personService.isPersonCreated());
        } else {
            Assertions.assertFalse(personService.isPersonCreated());
        }
    }
}