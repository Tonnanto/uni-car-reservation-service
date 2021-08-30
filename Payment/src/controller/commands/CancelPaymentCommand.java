package controller.commands;

import controller.Config;
import controller.PaymentService;

public class CancelPaymentCommand extends PaymentServiceCommand {
    public CancelPaymentCommand(PaymentService receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.cancelPayment();
    }

    @Override
    public String getDescription() {
        return Config.resourceBundle.getString("payment.controller.commands.CancelPaymentCommand.Description");
    }
}
