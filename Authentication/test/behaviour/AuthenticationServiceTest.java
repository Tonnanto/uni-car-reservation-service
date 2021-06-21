package behaviour;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import structure.Credential;
import structure.Subject;
import structure.UserNamePasswordStrategy;

public class AuthenticationServiceTest {
    Subject subject;
    private Credential credential;
    private AuthenticationService authenticationService;

    @BeforeEach
    void setUp() {
        authenticationService = new AuthenticationService();

        subject = new Subject();


        credential = new UserNamePasswordStrategy();

    }

    @Test
    void canCredentialBeCreated() {
        authenticationService.setCredential(credential);
        Assertions.assertTrue(authenticationService.authenticateSubject(subject));
    }

}
