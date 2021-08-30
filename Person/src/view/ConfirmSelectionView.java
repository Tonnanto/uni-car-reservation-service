package view;

import controller.Command;
import controller.Config;
import controller.PersonService;
import controller.commands.FinishSelectionCommand;
import controller.commands.ResetSelectionCommand;

import java.util.ArrayList;
import java.util.List;

public class ConfirmSelectionView extends SelectionView {
    private final PersonService personService;

    public ConfirmSelectionView(PersonService personService) {
        this.personService = personService;
    }

    @Override
    protected List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new FinishSelectionCommand(personService));
        commands.add(new ResetSelectionCommand(personService));
        return commands;
    }

    @Override
    protected String getMessage() {
        return Config.resourceBundle.getString("person.view.ConfirmSelectionView.Message");
    }
}
