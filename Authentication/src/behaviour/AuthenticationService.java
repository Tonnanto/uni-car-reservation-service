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

    public boolean authenticateSubject(Subject subject) {
        return credential.authenticate(subject);
    }
}
