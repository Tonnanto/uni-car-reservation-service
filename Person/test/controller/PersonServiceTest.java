package controller;

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
        // For each Person Type:

            // SelectPersonTypeCommand executen
            // Prüfen ob die Person erstellt wurde
            // ResetSelectionCommand executen
            // Prüfen ob die Person entfernt wurde

            // SelectPersonTypeCommand executen
            // Prüfen ob die Person erstellt wurde
            // SetNameCommand executen
            // Prüfen ob die Person den richtigen name hat
            // SetEmailCommand executen
            // Prüfen ob die Person die richtigen email hat
            // FinishSelectionCommand executen
            // Prüfen ob isPersonCreated == true?

        // Prüfen ob 2 Personen erstellt
        // Assertions.assertEquals(2, PersonFactory.getPersonCount());
    }
}
