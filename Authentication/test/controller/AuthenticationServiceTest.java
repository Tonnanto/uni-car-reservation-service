package controller;


import controller.commands.SelectCredentialsCommand;
import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AuthenticationServiceTest {

    @Test
    void canSubjectBeAuthenticatedWithFinger() {
        Person person = PersonFactory.createPerson(PersonType.NATURAL_PERSON);
        AuthenticationService authenticationService = new AuthenticationService((Subject) person);

        new SelectCredentialsCommand(authenticationService, new FingerPrintStrategy()).execute();
        Assertions.assertTrue(authenticationService.getCredential() instanceof FingerPrintStrategy);
        authenticationService.updateSubjectAuthenticated();
        Assertions.assertTrue(authenticationService.isSubjectAuthenticated());
        authenticationService.logout();
        Assertions.assertFalse(authenticationService.isSubjectAuthenticated());
    }

    @Test
    void canSubjectBeAuthenticatedWithEye() {
        Person person = PersonFactory.createPerson(PersonType.NATURAL_PERSON);
        AuthenticationService authenticationService = new AuthenticationService((Subject) person);

        new SelectCredentialsCommand(authenticationService, new EyeScanStrategy()).execute();
        Assertions.assertTrue(authenticationService.getCredential() instanceof EyeScanStrategy);
        authenticationService.updateSubjectAuthenticated();
        Assertions.assertTrue(authenticationService.isSubjectAuthenticated());
        authenticationService.logout();
        Assertions.assertFalse(authenticationService.isSubjectAuthenticated());
    }


    @Test
    void canSubjectBeAuthenticatedWithPassword() {
        Person person = PersonFactory.createPerson(PersonType.NATURAL_PERSON);
        AuthenticationService authenticationService = new AuthenticationService((Subject) person);

        new SelectCredentialsCommand(authenticationService, new UserNamePasswordStrategy()).execute();
        Assertions.assertTrue(authenticationService.getCredential() instanceof UserNamePasswordStrategy);
        UserNamePasswordStrategy usernamePassword = (UserNamePasswordStrategy) authenticationService.getCredential();
        authenticationService.updateSubjectAuthenticated();
        Assertions.assertFalse(authenticationService.isSubjectAuthenticated());
        usernamePassword.setUsername("test");
        authenticationService.updateSubjectAuthenticated();
        Assertions.assertFalse(authenticationService.isSubjectAuthenticated());
        usernamePassword.setPassword("test");
        authenticationService.updateSubjectAuthenticated();
        Assertions.assertTrue(authenticationService.isSubjectAuthenticated());
        authenticationService.logout();
        Assertions.assertFalse(authenticationService.isSubjectAuthenticated());
    }
}
