package controller.commands;

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
}
