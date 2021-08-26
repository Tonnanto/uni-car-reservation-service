package view;

import controller.Config;
import controller.PaymentService;

public class ShowAuthenticationStatusView extends View {
    private final PaymentService paymentService;

    public ShowAuthenticationStatusView(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    protected String getMessage() {
        if (paymentService.isUserAuthenticated()) {
            return Config.resourceBundle.getString("payment.view.ShowAuthenticationStatusView.getMessage1");
        }
        return Config.resourceBundle.getString("payment.view.SelectPaymentTypeView.getMessage2");
    }
}
