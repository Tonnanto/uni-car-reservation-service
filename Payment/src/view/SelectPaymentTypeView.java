package view;

import controller.Command;
import controller.Config;
import controller.PaymentService;
import controller.commands.SelectPaymentTypeCommand;
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
        commands.add(new SelectPaymentTypeCommand(paymentService, PaymentType.PAYPAL));
        commands.add(new SelectPaymentTypeCommand(paymentService, PaymentType.GOOGLE_WALLET));
        commands.add(new SelectPaymentTypeCommand(paymentService, PaymentType.MONEY_WALLET));
        return commands;
    }

    @Override
    protected String getMessage() {
        return Config.resourceBundle.getString("payment.view.SelectPaymentTypeView.getMessage");
    }
}
