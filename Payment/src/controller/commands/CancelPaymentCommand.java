package controller.commands;

import controller.PaymentService;

public class CancelPaymentCommand extends PaymentServiceCommand {
    public CancelPaymentCommand(PaymentService receiver) {
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
