package view;

import controller.Command;
import controller.PaymentService;
import controller.commands.CancelPaymentCommand;
import controller.commands.ConfirmPaymentCommand;

import java.util.ArrayList;
import java.util.List;

public class ConfirmPaymentView extends SelectionView {
    private final PaymentService paymentService;

    public ConfirmPaymentView(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    protected List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new ConfirmPaymentCommand(paymentService));
        commands.add(new CancelPaymentCommand(paymentService));
        return commands;
    }

    @Override
    protected String getMessage() {
        // TODO: Localization
        return "Confirm?";
    }
}
