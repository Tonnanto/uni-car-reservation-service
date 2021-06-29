package view;

import controller.Command;

public class EnterPasswordView extends StringInputView {
    @Override
    protected Command getCommand(String inputString) {
        return null;
    }

    @Override
    protected String getMessage() {
        return null;
    }
}
