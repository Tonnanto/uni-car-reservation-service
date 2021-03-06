package view;

import controller.Config;
import controller.PersonService;
import model.NaturalPerson;
import model.PersonType;

public class ShowPersonView extends View {

    private final PersonService personService;

    public ShowPersonView(PersonService personService) {
        this.personService = personService;
    }

    @Override
    protected String getMessage() {

        if (personService.getPerson() == null) {
            return Config.resourceBundle.getString("person.view.ShowPersonView.Message1");
        }

        String message = Config.resourceBundle.getString("person.view.ShowPersonView.Message2") + "\s";

        PersonType personType = personService.getPerson() instanceof NaturalPerson ? PersonType.NATURAL_PERSON : PersonType.LEGAL_PERSON;
        String name = personService.getPerson().getName();
        String email = personService.getPerson().getEmail();

        message += String.format("\n" + Config.resourceBundle.getString("person.view.ShowPersonView.Message3") + " %s", personType);

        if (name != null)
            message += String.format("\nName: %s", name);

        if (email != null)
            message += String.format("\nEmail: %s", email);

        return message;
    }
}
