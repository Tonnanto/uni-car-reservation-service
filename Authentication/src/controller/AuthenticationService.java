package controller;

import model.*;
import view.EnterPasswordView;
import view.EnterUserNameView;
import view.SelectCredentialView;

public class AuthenticationService {

    private Credential credential;

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(String strategy) {

        switch (strategy) {
            case "Username and Password" -> {
                this.credential = new UserNamePasswordStrategy();
                new EnterUserNameView(this, (UserNamePasswordStrategy) credential).display();
                new EnterPasswordView(this, (UserNamePasswordStrategy) credential).display();
            }
            case "Fingerprint" -> this.credential = new FingerPrintStrategy();
            case "Eyescan" -> this.credential = new EyeScanStrategy();
        }

    }

    /**
     * Authenticate a person or system with the credential they choose
     *
     * @param subject Person or system that wants to authenticate
     * @return successful or unsuccessful authentication
     */

    public boolean authenticateSubject(Subject subject) {

        new SelectCredentialView(this).display();

        return credential.authenticate(subject);
    }
}
