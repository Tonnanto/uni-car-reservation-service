package view;

import controller.Config;
import controller.PaymentService;

public class ShowPaymentDetailsView extends View {
    private final PaymentService paymentService;

    public ShowPaymentDetailsView(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    protected String getMessage() {

        String message = Config.resourceBundle.getString("payment.view.SelectPaymentDetailsView.Message1") + "\n";

        message += String.format("\n" + Config.resourceBundle.getString("payment.view.SelectPaymentDetailsView.Message2") + " %s", paymentService.getCurrencyAmount());

        if (paymentService.getPayment() != null) {
            message += String.format("\n" + Config.resourceBundle.getString("payment.view.SelectPaymentDetailsView.Message3") + " %s", paymentService.getPayment().getPaymentType());

            if (paymentService.getPayment().getSender() != null)
                message += String.format("\n" + Config.resourceBundle.getString("payment.view.SelectPaymentDetailsView.Message4") + " %s", paymentService.getPayment().getSender().getEmail());

            if (paymentService.getPayment().getReceiver() != null)
                message += String.format("\n" + Config.resourceBundle.getString("payment.view.SelectPaymentDetailsView.Message5") + " %s", paymentService.getPayment().getReceiver().getEmail());
        }

        return message;
    }
}