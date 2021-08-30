package view;

import controller.Command;
import controller.Config;
import controller.PersonService;
import controller.commands.SetEmailCommand;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnterEmailView extends StringInputView {

    private final PersonService personService;

    public EnterEmailView(PersonService personService) {
        this.personService = personService;
    }

    @Override
    protected Command getCommand(String inputString) {
        return new SetEmailCommand(personService, inputString);
    }

    @Override
    protected String getMessage() {
        return Config.resourceBundle.getString("person.view.EnterEmailView.Message");
    }

    @Override
    protected boolean isValidString(String s) {
        String regex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s.toLowerCase());
        return matcher.matches();
    }


    @Override
    protected String getValidationMessage() {
        return Config.resourceBundle.getString("person.view.EnterEmailView.ValidationMessage");
    }
}
