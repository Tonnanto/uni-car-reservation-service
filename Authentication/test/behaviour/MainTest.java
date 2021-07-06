package behaviour;

import controller.AuthenticationService;
import controller.PersonService;
import model.PersonType;
import model.Subject;
import view.SelectAuthenticationServiceView;

public class MainTest {

    public static void main(String[] args) {

        PersonService personService = new PersonService();
        Subject subject = (Subject) personService.createPerson(PersonType.NATURAL_PERSON);

        AuthenticationService authenticationService = new AuthenticationService(subject);

        new SelectAuthenticationServiceView(authenticationService).display();
    }
}
