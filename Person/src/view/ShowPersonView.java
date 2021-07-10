package view;

import controller.PersonService;

public class ShowPersonView extends View{

    private final PersonService personService;

    public ShowPersonView(PersonService personService) { this.personService = personService; }

    @Override
    protected String getMessage() {
        String message = "Selected Person:\s";

        message += String.format("\nPersonType: %s", personService.getPersonType());

        if (personService.getName() != null)
            message += String.format("\nName: %s", personService.getName());

        if (personService.getEmail() != null)
            message += String.format("\nEmail: %s", personService.getEmail());

        return message;
    }
}
