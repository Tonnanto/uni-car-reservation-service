package controller;

import model.*;
import view.*;

public class AuthenticationService {

    private final Subject subject;
    private Credential credential;
    private boolean isSubjectAuthenticated = false;

    public AuthenticationService(Subject subject) {
        this.subject = subject;
    }

    public void setCredential(Credential strategy) {

        this.credential = strategy;
    }

    /**
     * Authenticate a person or system with the credential they choose
     */
    public void authenticateSubject() {
        while (!isSubjectAuthenticated) {
            if (credential == null) {
                new SelectCredentialView(this).display();
                continue;
            }
            if (credential instanceof UserNamePasswordStrategy) {
                new EnterUserNameView(this).display();
                if (credential != null)
                    new EnterPasswordView(this).display();
                continue;
            }
            if (credential instanceof FingerPrintStrategy) {
                new EnterFingerView(this).display();
                continue;
            }
            if (credential instanceof EyeScanStrategy)
                new EnterEyeView(this).display();
        }
        new ShowLoginStatusView(this).display();
    }

    public void setUsername(String username) {
        if (credential instanceof UserNamePasswordStrategy) {
            ((UserNamePasswordStrategy) credential).setUsername(username);
        }
    }

    public void setPassword(String password) {
        if (credential instanceof UserNamePasswordStrategy) {
            ((UserNamePasswordStrategy) credential).setPassword(password);
        }
    }

    public boolean isSubjectAuthenticated() {
        return isSubjectAuthenticated;
    }

    public void logout() {
        credential = null;
        isSubjectAuthenticated = false;
        new ShowLogOutView().display();
    }

    public void updateSubjectAuthenticated() {
        isSubjectAuthenticated = credential.authenticate(subject);
    }

    public void resetCredential() {
        credential = null;
    }

    public void resetUsername() {
        if (credential instanceof UserNamePasswordStrategy) {
            ((UserNamePasswordStrategy) credential).setUsername(null);
        }
    }

    public Credential getCredential() {
        return credential;
    }
}