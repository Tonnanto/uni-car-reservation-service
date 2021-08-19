package controller.commands;

import controller.PaymentService;
import view.Language;

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
        return Language.resourceBundle.getString("payment.controller.commands.ConfirmPaymentCommand.getDescription");
    }
}
