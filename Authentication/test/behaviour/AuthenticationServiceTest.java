package behaviour;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import structure.EyeScanStrategy;
import structure.FingerPrintStrategy;
import structure.Subject;
import structure.UserNamePasswordStrategy;

public class AuthenticationServiceTest {
    Subject subject;
    private AuthenticationService authenticationService;

    @BeforeEach
    void setUp() {
        authenticationService = new AuthenticationService();


    }

    @Test
    void canSubjectBeAuthenticated() {

        subject = new Subject();

        authenticationService.setCredential(new EyeScanStrategy());
        Assertions.assertTrue(authenticationService.authenticateSubject(subject));

        authenticationService.setCredential(new UserNamePasswordStrategy());
        Assertions.assertTrue(authenticationService.authenticateSubject(subject));

        authenticationService.setCredential(new FingerPrintStrategy());
        Assertions.assertTrue(authenticationService.authenticateSubject(subject));
    }

}
