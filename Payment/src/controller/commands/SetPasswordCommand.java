package controller.commands;

import controller.PaymentService;

public class SetPasswordCommand extends PaymentServiceCommand {
    public SetPasswordCommand(PaymentService receiver) {
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
