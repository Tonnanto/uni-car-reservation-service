package controller;

import model.*;
import view.*;

public class AuthenticationService implements Observer {

    private Credential credential;
    private Subject subject;
    private boolean isSubjectAuthenticated = false;

    public AuthenticationService(Subject subject) {
        this.subject = subject;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(String strategy) {

        switch (strategy) {
            case "Username and Password" -> this.credential = new UserNamePasswordStrategy(this);
            case "Fingerprint" -> this.credential = new FingerPrintStrategy(this);
            case "Eyescan" -> this.credential = new EyeScanStrategy(this);
        }

    }

    /**
     * Authenticate a person or system with the credential they choose
     *
     * @return successful or unsuccessful authentication
     */

    public boolean authenticateSubject() {
        return isSubjectAuthenticated = credential.authenticate(subject);
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

        if (!isSubjectAuthenticated) return;
        if (credential == null) {
            new SelectCredentialView(this).display();
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
            return;
        }
    }

    public boolean isSubjectAuthenticated() {  //Todo temporär zum testen
        return isSubjectAuthenticated;
    }
}
