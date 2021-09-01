package controller.commands;

import controller.PaymentService;

public class SetPaymentPasswordCommand extends PaymentServiceCommand {
    private final String password;

    public SetPaymentPasswordCommand(PaymentService receiver, String password) {
        super(receiver);
        this.password = password;
    }

    @Override
    public void execute() {
        receiver.setPassword(password);
    }
}
