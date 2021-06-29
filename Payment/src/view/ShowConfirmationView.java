package view;

import controller.PaymentService;

public class ShowConfirmationView extends View {
    private final PaymentService paymentService;

    public ShowConfirmationView(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    protected String getMessage() {
        return paymentService.getPayment().createConfirmation(paymentService.isAmountPayed());
    }
}
