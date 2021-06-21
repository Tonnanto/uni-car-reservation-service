package behaviour;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import structure.Credential;
import structure.UserNamePasswordStrategy;

public class AuthenticationServiceTest {
//    Subject subject;
    private Credential credential;
    private AuthenticationService authenticationService;

    @BeforeEach
    void setUp() {
        AuthenticationService authenticationService = new AuthenticationService();
        this.authenticationService = authenticationService;

        Subject subject = new Subject();
        this.subject = subject;

        Credential password = new UserNamePasswordStrategy();
        this.credential = password;
    }

    @Test
    void canCredentialBeCreated() {
        Assertions.assertTrue(authenticationService.authenticateSubject(subject));
    }

}
