package controller;

import org.junit.jupiter.api.AfterAll;
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

    }
}
