package controller.commands;

import controller.Command;
import controller.PaymentService;

public abstract class PaymentServiceCommand implements Command {
    final PaymentService receiver;

    public PaymentServiceCommand(PaymentService receiver) {
        this.receiver = receiver;
    }

    @Override
    public String getDescription() {
        return "";
    }
}
