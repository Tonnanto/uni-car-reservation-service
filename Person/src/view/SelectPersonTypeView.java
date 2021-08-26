package view;

import controller.Command;
import controller.Config;
import controller.PersonService;
import controller.commands.SelectPersonTypeCommand;
import model.PersonType;

import java.util.ArrayList;
import java.util.List;

public class SelectPersonTypeView extends SelectionView {
    private final PersonService personService;

    public SelectPersonTypeView(PersonService personService) {
        this.personService = personService;
    }

    @Override
    protected List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new SelectPersonTypeCommand(personService, PersonType.NATURAL_PERSON));
        commands.add(new SelectPersonTypeCommand(personService, PersonType.LEGAL_PERSON));

        return commands;
    }

    @Override
    protected String getMessage() {

        return Config.resourceBundle.getString("person.view.SelectPersonTypeView.Message");
    }
}
