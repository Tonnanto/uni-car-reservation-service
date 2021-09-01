package view;

import controller.Command;
import controller.Config;
import controller.PaymentService;
import controller.commands.CancelPaymentCommand;
import controller.commands.SetPaymentPasswordCommand;

public class EnterPaymentPasswordView extends StringInputView {
    private final PaymentService paymentService;

    public EnterPaymentPasswordView(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    protected Command getCommand(String inputString) {
        return new SetPaymentPasswordCommand(paymentService, inputString);
    }

    @Override
    protected Command getCancelCommand() {
        return new CancelPaymentCommand(paymentService);
    }

    @Override
    protected String getMessage() {
        return Config.resourceBundle.getString("payment.view.EnterPasswordView.Message") + " " + paymentService.getPayment().getPaymentType();
    }
}
