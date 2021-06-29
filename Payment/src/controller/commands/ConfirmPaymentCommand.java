package controller.commands;

import controller.PaymentService;

public class ConfirmPaymentCommand extends PaymentServiceCommand {
    public ConfirmPaymentCommand(PaymentService receiver) {
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
