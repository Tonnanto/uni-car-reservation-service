package view;

import controller.Command;

public class EnterUsernameView extends StringInputView {
    @Override
    protected Command getCommand(String inputString) {
        return null;
    }

    @Override
    protected String getMessage() {
        return null;
    }
}
