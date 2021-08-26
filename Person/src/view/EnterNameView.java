package view;

import controller.Command;
import controller.Config;
import controller.PersonService;
import controller.commands.SetNameCommand;

public class EnterNameView extends StringInputView {

    private final PersonService personService;

    public EnterNameView(PersonService personService) {
        this.personService = personService;
    }

    @Override
    protected Command getCommand(String inputString) {
        return new SetNameCommand(personService, inputString);
    }

    @Override
    protected String getMessage() {
        return Config.resourceBundle.getString("person.view.EnterNameView.Message");
    }

    @Override
    protected boolean isValidString(String s) {
        return s.length() > 3;
    }

    @Override
    protected String getValidationMessage() {
        return Config.resourceBundle.getString("person.view.EnterNameView.ValidationMessage");
    }
}
