package controller.commands;

import controller.Config;
import controller.PaymentService;

public class ConfirmPaymentCommand extends PaymentServiceCommand {
    public ConfirmPaymentCommand(PaymentService receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.confirmPayment();
    }

    @Override
    public String getDescription() {
        return Config.resourceBundle.getString("payment.controller.commands.ConfirmPaymentCommand.Description");
    }
}
