package view;

import controller.Command;
import controller.PersonService;

import java.util.List;

public class ConfirmSelectionView extends SelectionView {
    public ConfirmSelectionView(PersonService personService) {
    }

    @Override
    protected List<Command> getCommands() {
        return null;
    }

    @Override
    protected String getMessage() {
        return null;
    }
}
