package view;

import controller.Command;
import controller.PersonService;
import controller.commands.FinishSelectionCommand;
import controller.commands.ResetSelectionCommand;

import java.util.ArrayList;
import java.util.List;

public class ConfirmSelectionView extends SelectionView {
    private PersonService personService;

    public ConfirmSelectionView(PersonService personService) { this.personService = personService; }

    @Override
    protected List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new ResetSelectionCommand(personService));
        commands.add(new FinishSelectionCommand(personService));
        return commands;
    }

    @Override
    protected String getMessage() {
        return Language.resourceBundle.getString("person.view.ConfirmSelectionView.Message");
    }
}
