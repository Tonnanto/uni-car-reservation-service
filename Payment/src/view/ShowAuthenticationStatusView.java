package view;

import controller.PaymentService;

public class ShowAuthenticationStatusView extends View {
    private final PaymentService paymentService;

    public ShowAuthenticationStatusView(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    protected String getMessage() {
        if (paymentService.isUserAuthenticated()) {
            return Language.resourceBundle.getString("payment.view.ShowAuthenticationStatusView.getMessage1");
        }
        return Language.resourceBundle.getString("payment.view.SelectPaymentTypeView.getMessage2");
    }
}
