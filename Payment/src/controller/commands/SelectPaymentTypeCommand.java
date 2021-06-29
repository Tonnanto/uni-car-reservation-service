package controller.commands;

import controller.PaymentService;

public class SelectPaymentTypeCommand extends PaymentServiceCommand {
    public SelectPaymentTypeCommand(PaymentService receiver) {
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
