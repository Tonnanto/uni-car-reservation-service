package controller.commands;

import controller.Command;
import controller.PaymentService;

public abstract class PaymentServiceCommand implements Command {
    PaymentService receiver;

    public PaymentServiceCommand(PaymentService receiver) {
        this.receiver = receiver;
    }
}
