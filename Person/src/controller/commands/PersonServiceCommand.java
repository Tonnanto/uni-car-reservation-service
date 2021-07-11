package controller.commands;

import controller.Command;
import controller.PersonService;

public abstract class PersonServiceCommand implements Command {
    protected PersonService receiver;

    public PersonServiceCommand(PersonService receiver) {
        this.receiver = receiver;
    }
}
