package view;

import controller.PaymentService;

import java.util.concurrent.TimeUnit;

public class ShowPaymentConfirmationView extends View {
    private final PaymentService paymentService;

    public ShowPaymentConfirmationView(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    protected String getMessage() {
        // printing 5 dots to indicate the payment process
        for (int i = 0; i < 5; i++) {
            System.out.print(".");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (Exception ignored) {
            }
        }
        return paymentService.getPayment().createConfirmation(paymentService.isAmountPayed());
    }
}
