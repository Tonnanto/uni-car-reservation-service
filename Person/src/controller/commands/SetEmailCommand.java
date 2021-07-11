package controller.commands;

import controller.Command;
import controller.PersonService;

public class SetEmailCommand extends PersonServiceCommand {

    private final String email;


    public SetEmailCommand(PersonService receiver, String email) {
        super(receiver);
        this.email = email;
    }

    @Override
    public void execute() {
        receiver.setEmail(email);
    }

    //TODO Wie in SetNameCommand "braucht" man wirklich eine getDescription?

    @Override
    public String getDescription() {
        return "getDescription of Email :D";
    }
}
