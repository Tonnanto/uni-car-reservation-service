package controller.commands;

import controller.PaymentService;

public class SetUsernameCommand extends PaymentServiceCommand {
    public SetUsernameCommand(PaymentService receiver) {
        super(receiver);
    }

    @Override
    public void execute() {

    }

    @Override
    public String getDescription() {
        return null;
    }
}
