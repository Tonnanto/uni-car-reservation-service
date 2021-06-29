package view;

import controller.PaymentService;

public class ShowPaymentDetailsView extends View {
    private final PaymentService paymentService;

    public ShowPaymentDetailsView(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    protected String getMessage() {
        String message = "Your Payment:\n";

        message += String.format("\namount: %s", paymentService.getCurrencyAmount());

        if (paymentService.getPayment() != null) {
            message += String.format("\nmethod: %s", paymentService.getPayment().getPaymentType());

            if (paymentService.getPayment().getSender() != null)
                message += String.format("\nsender: %s", paymentService.getPayment().getSender().getAddress());

            if (paymentService.getPayment().getReceiver() != null)
                message += String.format("\nreceiver: %s", paymentService.getPayment().getReceiver().getAddress());
        }

        return message;
    }
}