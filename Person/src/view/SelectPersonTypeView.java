package view;

import controller.commands.SelectPersonTypeCommand;
import controller.Command;
import controller.PersonService;
import model.PersonType;

import java.util.ArrayList;
import java.util.List;

public class SelectPersonTypeView extends SelectionView {
    private PersonService personService;

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

        return "Are you a Natural Person or a Legal Person";
    }
}
