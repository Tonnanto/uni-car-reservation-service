package behaviour;

import controller.AuthenticationService;
import controller.PersonService;
import model.PersonType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.EyeScanStrategy;
import model.FingerPrintStrategy;
import model.Subject;
import model.UserNamePasswordStrategy;

public class AuthenticationServiceTest {
    Subject subject;
    private AuthenticationService authenticationService;

    @BeforeEach
    void setUp() {
        authenticationService = new AuthenticationService();


    }

    @Test
    void canSubjectBeAuthenticated() {

        PersonService personService = new PersonService();
        subject = (Subject) personService.createPerson(PersonType.NATURAL_PERSON);

        authenticationService.authenticateSubject(subject);
    }

}
