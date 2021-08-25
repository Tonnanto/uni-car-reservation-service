package controller.commands;

import controller.PersonService;


public class SetNameCommand extends PersonServiceCommand {

    private final String name;

    public SetNameCommand(PersonService receiver, String name) {
        super(receiver);
        this.name = name;
    }

    @Override
    public void execute() {
        receiver.setName(name);
    }
}

