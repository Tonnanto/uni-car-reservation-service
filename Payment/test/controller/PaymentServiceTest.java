package controller;

import model.Currency;
import model.CurrencyAmount;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PaymentServiceTest {

    private static PaymentService paymentService;

    @BeforeAll
    protected static void setUp() {
        paymentService = new PaymentService();
    }

    @AfterAll
    protected static void tearDown() {

    }

    @Test
    protected void canAmountBePayed() {

        CurrencyAmount amount = new CurrencyAmount(300, Currency.EURO);

        Assertions.assertTrue(paymentService.payAmount(amount));

    }

    @Test
    protected void cantNegativeAmountBePayed() {
        CurrencyAmount amount;

        amount = new CurrencyAmount(-300, Currency.EURO);
        Assertions.assertFalse(paymentService.payAmount(amount));

        amount = new CurrencyAmount(0, Currency.EURO);
        Assertions.assertFalse(paymentService.payAmount(amount));
    }


}
