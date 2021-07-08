package controller;

import model.*;
import view.*;

public class AuthenticationService implements Observer {

    private Credential credential;
    private final Subject subject;
    private boolean isSubjectAuthenticated = false;

    public AuthenticationService(Subject subject) {
        this.subject = subject;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(String strategy) {

        switch (strategy) {
            case "Username and Password" -> new UserNamePasswordStrategy(this);
            case "Fingerprint" -> new FingerPrintStrategy(this);
            case "Eyescan" -> new EyeScanStrategy(this);
            case "Go back" -> {
                credential = null;
                new SelectAuthenticationServiceView(this);
            }
        }

    }

    /**
     * Authenticate a person or system with the credential they choose
     */

    public boolean authenticateSubject() {
        update(credential);
        new SelectAuthenticationServiceView(this).display();
        return isSubjectAuthenticated;
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

    @Override
    public void update(Object object) {

        if (object instanceof Credential)
            credential = (Credential) object;

        if (isSubjectAuthenticated) {
            new ShowLoginStatusView(this).display();
            return;
        }
        if (credential == null) {
            new SelectCredentialView(this).display();
            return;
        }
        if (credential instanceof UserNamePasswordStrategy && ((UserNamePasswordStrategy) credential).getUsername() == null) {
            new EnterUserNameView(this).display();
            return;
        }
        if (credential instanceof UserNamePasswordStrategy && ((UserNamePasswordStrategy) credential).getPassword() == null) {
            new EnterPasswordView(this).display();
            return;
        }
        if (credential instanceof FingerPrintStrategy) {
            new EnterFingerView(this).display();
            return;
        }
        if (credential instanceof EyeScanStrategy) {
            new EnterEyeView(this).display();
        }
    }

    public boolean isSubjectAuthenticated() {
        return isSubjectAuthenticated;
    }

    public void logout() {
        credential = null;
        isSubjectAuthenticated = false;
        new ShowLogOutView().display();
        new SelectAuthenticationServiceView(this).display();
    }

    public void updateSubjectAuthenticated() {
        isSubjectAuthenticated = credential.authenticate(subject);
        update(credential);
    }

    public void resetCredential() {
        credential = null;
        new SelectCredentialView(this).display();
    }

    public void resetUsername() {
        if (credential instanceof UserNamePasswordStrategy) {
            ((UserNamePasswordStrategy) credential).setUsername(null);
        }
    }

    public void showAuthenticationStatus(){
        new ShowLoginStatusView(this).display();
        new SelectAuthenticationServiceView(this).display();
    }
}