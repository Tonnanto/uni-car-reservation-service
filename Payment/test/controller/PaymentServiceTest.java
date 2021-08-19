package controller;

import controller.commands.*;
import model.Currency;
import model.CurrencyAmount;
import model.Payment;
import model.PaymentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PaymentServiceTest {

    private static PaymentService paymentService;

    @BeforeAll
    protected static void setUp() {
        paymentService = new PaymentService();
    }

    @Test
    protected void canAmountBePayed() {
        CurrencyAmount amount = new CurrencyAmount(300, Currency.EURO);
        paymentService.currencyAmount = amount;

        // Simulating the payment process for each of the payment types
        for (PaymentType paymentType: PaymentType.values()) {

            // Reset PaymentService
            new CancelPaymentCommand(paymentService).execute();
            Assertions.assertNull(paymentService.getPayment());

            // Simulate: payment type selection and credentials entering
            new SelectPaymentTypeCommand(paymentService, paymentType).execute();
            new SetPaymentEmailCommand(paymentService, "anton@stamme.de").execute();
            new SetPasswordCommand(paymentService, "password420").execute();
            Assertions.assertTrue(paymentService.isUserAuthenticated());

            // Simulate: payment confirmation
            new ConfirmPaymentCommand(paymentService).execute();
            Payment payment = paymentService.getPayment();

            Assertions.assertTrue(paymentService.isAmountPayed());
            Assertions.assertNotNull(payment);
            Assertions.assertEquals(amount, payment.getCurrencyAmount());
            Assertions.assertEquals(paymentType, payment.getPaymentType());
        }
    }

    @Test
    protected void cantNegativeAmountBePayed() {
        CurrencyAmount amount;

        amount = new CurrencyAmount(-300, Currency.EURO);
        Assertions.assertNull(paymentService.payAmount(amount));

        amount = new CurrencyAmount(0, Currency.EURO);
        Assertions.assertNull(paymentService.payAmount(amount));
    }
}
