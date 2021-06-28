package view;

import controller.Command;
import controller.PersonService;

public class EnterEmailView extends StringInputView{
    public EnterEmailView(PersonService personService) {
    }

    @Override
    protected Command getCommand(String inputString) {
        return null;
    }

    @Override
    protected String getMessage() {
        return null;
    }
}
