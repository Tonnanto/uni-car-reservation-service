package view;

import controller.Command;
import controller.PaymentService;
import controller.commands.CancelPaymentCommand;
import controller.commands.SetPasswordCommand;

public class EnterPasswordView extends StringInputView {
    private final PaymentService paymentService;

    public EnterPasswordView(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    protected Command getCommand(String inputString) {
        return new SetPasswordCommand(paymentService, inputString);
    }

    @Override
    protected Command getCancelCommand() {
        return new CancelPaymentCommand(paymentService);
    }

    @Override
    protected String getMessage() {
        return "Please enter your password for " + paymentService.getPayment().getPaymentType();
    }
}
