package view;

import controller.Command;
import controller.Config;
import controller.PaymentService;
import controller.commands.SetPaymentTypeCommand;
import model.PaymentType;

import java.util.ArrayList;
import java.util.List;

public class SelectPaymentTypeView extends SelectionView {
    private final PaymentService paymentService;

    public SelectPaymentTypeView(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    protected List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new SetPaymentTypeCommand(paymentService, PaymentType.PAYPAL));
        commands.add(new SetPaymentTypeCommand(paymentService, PaymentType.GOOGLE_WALLET));
        commands.add(new SetPaymentTypeCommand(paymentService, PaymentType.MONEY_WALLET));
        return commands;
    }

    @Override
    protected String getMessage() {
        return Config.resourceBundle.getString("payment.view.SelectPaymentTypeView.Message");
    }
}
