package view;

import controller.Command;
import controller.PaymentService;
import controller.commands.CancelPaymentCommand;
import controller.commands.SetUsernameCommand;

public class EnterUsernameView extends StringInputView {
    private final PaymentService paymentService;

    public EnterUsernameView(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    protected Command getCommand(String inputString) {
        return new SetUsernameCommand(paymentService, inputString);
    }

    @Override
    protected Command getCancelCommand() {
        return new CancelPaymentCommand(paymentService);
    }

    @Override
    protected String getMessage() {
        return "Please enter your username for " + paymentService.getPayment().getPaymentType();
    }
}
