package controller.commands;

import controller.PaymentService;

public class SetPaymentEmailCommand extends PaymentServiceCommand {
    private final String email;

    public SetPaymentEmailCommand(PaymentService receiver, String email) {
        super(receiver);
        this.email = email;
    }

    @Override
    public void execute() {
        receiver.setEmail(email);
    }

    @Override
    public String getDescription() {
        return null;
    }
}
