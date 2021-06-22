package controller;

import model.PersonType;
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
        Assertions.assertNotNull(personService.createPerson(PersonType.NATURAL_PERSON));
        Assertions.assertNotNull(personService.createPerson(PersonType.LEGAL_PERSON));

        Assertions.assertEquals(2, PersonService.getPersonCount());
    }

}
