package behaviour;

import structure.Credential;
import structure.Subject;

public class AuthenticationService {

    private Credential credential;

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    /**
     * Authenticate a person or system with the credential they choose
     * @param subject Person or system that wants to authenticate
     * @return successful or unsuccessful authentication
     */

    public boolean authenticateSubject(Subject subject) {
        return credential.authenticate(subject);
    }
}
