package controller;

import model.PersonFactory;
import model.PersonType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PersonServiceTest {

    private static PersonFactory personFactory;

    @BeforeAll
    protected static void setUp() {
        personFactory = new PersonFactory();
    }

    @Test
    protected void canPersonBeCreated() {
        Assertions.assertNotNull(personFactory.createPerson(PersonType.NATURAL_PERSON));
        Assertions.assertNotNull(personFactory.createPerson(PersonType.LEGAL_PERSON));

        Assertions.assertEquals(2, PersonFactory.getPersonCount());
    }

}
