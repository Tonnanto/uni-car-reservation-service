package view;

import controller.Command;
import controller.PersonService;
import controller.commands.SetNameCommand;

public class EnterNameView extends StringInputView {

    private final PersonService personService;

    public EnterNameView(PersonService personService) { this.personService = personService; }

    @Override
    protected Command getCommand(String inputString) {
        return new SetNameCommand(personService, inputString);
    }

    @Override
    protected String getMessage() { return "Please enter your Name:"; }

    @Override
    protected boolean isValidString (String s) { return s.length() > 3;}

    @Override
    protected String getValidationMessage() { return "Please enter a name with more than 3 characters";}
}
