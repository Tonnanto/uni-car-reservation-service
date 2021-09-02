package controller;


import controller.commands.LogOutCommand;
import controller.commands.SelectCredentialsCommand;
import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AuthenticationServiceTest {


    @Test
    void canSubjectBeAuthenticatedWithFinger() {
        Subject subject = new NaturalPerson(86);
        AuthenticationService authenticationService = new AuthenticationService(subject);

        new SelectCredentialsCommand(authenticationService, new FingerPrintStrategy()).execute();
        Assertions.assertTrue(authenticationService.getCredential() instanceof FingerPrintStrategy);
        authenticationService.updateSubjectAuthenticated();
        Assertions.assertTrue(authenticationService.isSubjectAuthenticated());
        new LogOutCommand(authenticationService).execute();
        Assertions.assertFalse(authenticationService.isSubjectAuthenticated());
    }

    @Test
    void canSubjectBeAuthenticatedWithEye() {
        Subject subject = new NaturalPerson(99);
        AuthenticationService authenticationService = new AuthenticationService(subject);

        new SelectCredentialsCommand(authenticationService, new EyeScanStrategy()).execute();
        Assertions.assertTrue(authenticationService.getCredential() instanceof EyeScanStrategy);
        authenticationService.updateSubjectAuthenticated();
        Assertions.assertTrue(authenticationService.isSubjectAuthenticated());
        new LogOutCommand(authenticationService).execute();
        Assertions.assertFalse(authenticationService.isSubjectAuthenticated());
    }


    @Test
    void canSubjectBeAuthenticatedWithPassword() {
        Subject subject = new NaturalPerson(27);
        AuthenticationService authenticationService = new AuthenticationService(subject);

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
        new LogOutCommand(authenticationService).execute();
        Assertions.assertFalse(authenticationService.isSubjectAuthenticated());
    }
}
