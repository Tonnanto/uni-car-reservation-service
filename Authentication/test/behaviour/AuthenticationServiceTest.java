package behaviour;


import controller.AuthenticationService;
import controller.PersonService;
import model.PersonFactory;
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



    }

    @Test
    void canSubjectBeAuthenticated() {


        PersonFactory personFactory = new PersonFactory();
        subject = (Subject) personFactory.createPerson(PersonType.NATURAL_PERSON);

        authenticationService.setCredential(new EyeScanStrategy());
        Assertions.assertTrue(authenticationService.authenticateSubject(subject));

        authenticationService.setCredential(new UserNamePasswordStrategy());
        Assertions.assertTrue(authenticationService.authenticateSubject(subject));

        authenticationService.setCredential(new FingerPrintStrategy());
        Assertions.assertTrue(authenticationService.authenticateSubject(subject));
    }

}
