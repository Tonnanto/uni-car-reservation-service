package view;

import controller.PaymentService;

public class ShowPaymentDetailsView extends View {
    private final PaymentService paymentService;

    public ShowPaymentDetailsView(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    protected String getMessage() {
        // TODO: Localization
        String message = "Your Payment:\n";

        message += String.format("\namount: %s", paymentService.getCurrencyAmount());

        if (paymentService.getPayment() != null) {
            message += String.format("\nmethod: %s", paymentService.getPayment().getPaymentType());

            if (paymentService.getPayment().getSender() != null)
                message += String.format("\nsender: %s", paymentService.getPayment().getSender().getEmail());

            if (paymentService.getPayment().getReceiver() != null)
                message += String.format("\nreceiver: %s", paymentService.getPayment().getReceiver().getEmail());
        }

        return message;
    }
}