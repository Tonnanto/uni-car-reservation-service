package controller.commands;

import controller.PaymentService;
import model.PaymentType;

public class SelectPaymentTypeCommand extends PaymentServiceCommand {
    private final PaymentType paymentType;

    public SelectPaymentTypeCommand(PaymentService receiver, PaymentType paymentType) {
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
