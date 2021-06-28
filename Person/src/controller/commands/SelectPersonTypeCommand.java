package controller.commands;

import controller.Command;
import controller.PersonService;
import model.PersonType;

public class SelectPersonTypeCommand extends PersonServiceCommand {
    private PersonType personType;

    public SelectPersonTypeCommand(PersonService receiver, PersonType personType) {
        super(receiver);
        this.personType = personType;
    }

    @Override
    public void execute() {
        receiver.selectPersonType(personType);
    }

    @Override
    public String getDescription() {
        return personType.name().replace("_", " ").toLowerCase();
    }
}
