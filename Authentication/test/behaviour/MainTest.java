package behaviour;

import controller.AuthenticationService;
import controller.PersonService;
import model.PersonType;
import model.Subject;

public class MainTest {

    public static void main(String[] args){

        AuthenticationService authenticationService = new AuthenticationService();

        PersonService personService = new PersonService();
        Subject subject = (Subject) personService.createPerson(PersonType.NATURAL_PERSON);

        authenticationService.authenticateSubject(subject);
    }
}
