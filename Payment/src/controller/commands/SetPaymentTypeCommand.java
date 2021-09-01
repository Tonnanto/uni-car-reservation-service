package controller.commands;

import controller.PaymentService;
import model.PaymentType;

public class SetPaymentTypeCommand extends PaymentServiceCommand {
    private final PaymentType paymentType;

    public SetPaymentTypeCommand(PaymentService receiver, PaymentType paymentType) {
        super(receiver);
        this.paymentType = paymentType;
    }

    @Override
    public void execute() {
        receiver.selectPaymentType(paymentType);
    }

    @Override
    public String getDescription() {
        return paymentType.toString();
    }
}
