package controller.commands;

import controller.PaymentService;
import view.Language;

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
        return Language.resourceBundle.getString("payment.controller.commands.CancelPaymentCommand.getDescription");
    }
}
