package controller;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StatisticsServiceTest {

    private static ContentService contentService;
    private static StatisticsService statisticsService;

    @BeforeAll
    protected static void setUp() {
        contentService = new ContentService();
        contentService.addDemoBookings(50);
        statisticsService = new StatisticsService(contentService.getRoot());
    }

    @Test
    protected void canSummaryBeCreated() {
        contentService = new ContentService();
        statisticsService = new StatisticsService(contentService.getRoot());
        contentService.addDemoBookings(50);

        // Verify that Summary Files exist in every Folder
        checkForSummaryFiles(contentService.getRoot(), 1);
    }


    @Test
    protected void canInitialSummaryBeCreated() {
        contentService = new ContentService();

        // Add demo bookings before hooking up statistics service
        contentService.addDemoBookings(50);

        // Verify that no Summary File exists yet
        checkForSummaryFiles(contentService.getRoot(), 0);

        // Initialize Statistics Service
        statisticsService = new StatisticsService(contentService.getRoot());

        // Verify that Summary Files exist in every Folder
        checkForSummaryFiles(contentService.getRoot(), 1);
    }

    /**
     * Helper method which verifies that each folder in the given hierarchy has x amount of SummaryFiles
     * @param folder the root of the content hierarchy to check in
     * @param expected the expected amount of summary files
     */
    private void checkForSummaryFiles(Folder folder, int expected) {
        Assertions.assertEquals(expected, folder.getContents().entrySet().stream().filter(entry -> entry.getKey().endsWith("_Summary")).count());
        for (Content content : folder.getContents().values()) {
            if (content instanceof Folder) {
                checkForSummaryFiles((Folder) content, expected);
            }
        }
    }

    @Test
    public void canGermanBookingsPaidByPayPalBeGotten() {
        statisticsService.getGermanBookingsPaidByPayPal();
        BookingStatisticVisitor lastStatistic = statisticsService.getLastStatistic();
        Assertions.assertEquals(Language.GERMAN, lastStatistic.getLanguage());
        Assertions.assertEquals(PaymentType.PAYPAL, lastStatistic.getPaymentType());

        if (lastStatistic.getBookingsCount() > 0) {
            Assertions.assertTrue(lastStatistic.getBookingsValue(Currency.EURO).getAmount() > 0);
        } else {
            Assertions.assertEquals(0, lastStatistic.getBookingsValue(Currency.EURO).getAmount());
        }
    }

    @Test
    public void canGermanBookingsPaidByGoogleWalletBeGotten() {
        statisticsService.getGermanBookingsPaidByGoogleWallet();
        BookingStatisticVisitor lastStatistic = statisticsService.getLastStatistic();
        Assertions.assertEquals(Language.GERMAN, lastStatistic.getLanguage());
        Assertions.assertEquals(PaymentType.GOOGLE_WALLET, lastStatistic.getPaymentType());

        if (lastStatistic.getBookingsCount() > 0) {
            Assertions.assertTrue(lastStatistic.getBookingsValue(Currency.EURO).getAmount() > 0);
        } else {
            Assertions.assertEquals(0, lastStatistic.getBookingsValue(Currency.EURO).getAmount());
        }
    }

    @Test
    public void canGermanBookingsPaidByMoneyWalletBeGotten() {
        statisticsService.getGermanBookingsPaidByMoneyWallet();
        BookingStatisticVisitor lastStatistic = statisticsService.getLastStatistic();
        Assertions.assertEquals(Language.GERMAN, lastStatistic.getLanguage());
        Assertions.assertEquals(PaymentType.MONEY_WALLET, lastStatistic.getPaymentType());

        if (lastStatistic.getBookingsCount() > 0) {
            Assertions.assertTrue(lastStatistic.getBookingsValue(Currency.EURO).getAmount() > 0);
        } else {
            Assertions.assertEquals(0, lastStatistic.getBookingsValue(Currency.EURO).getAmount());
        }
    }

    @Test
    public void canEnglishBookingsPaidByPayPalBeGotten() {
        statisticsService.getEnglishBookingsPaidByPayPal();
        BookingStatisticVisitor lastStatistic = statisticsService.getLastStatistic();
        Assertions.assertEquals(Language.ENGLISH, lastStatistic.getLanguage());
        Assertions.assertEquals(PaymentType.PAYPAL, lastStatistic.getPaymentType());

        if (lastStatistic.getBookingsCount() > 0) {
            Assertions.assertTrue(lastStatistic.getBookingsValue(Currency.EURO).getAmount() > 0);
        } else {
            Assertions.assertEquals(0, lastStatistic.getBookingsValue(Currency.EURO).getAmount());
        }
    }

    @Test
    public void canEnglishBookingsPaidByGoogleWalletBeGotten() {
        statisticsService.getEnglishBookingsPaidByGoogleWallet();
        BookingStatisticVisitor lastStatistic = statisticsService.getLastStatistic();
        Assertions.assertEquals(Language.ENGLISH, lastStatistic.getLanguage());
        Assertions.assertEquals(PaymentType.GOOGLE_WALLET, lastStatistic.getPaymentType());

        if (lastStatistic.getBookingsCount() > 0) {
            Assertions.assertTrue(lastStatistic.getBookingsValue(Currency.EURO).getAmount() > 0);
        } else {
            Assertions.assertEquals(0, lastStatistic.getBookingsValue(Currency.EURO).getAmount());
        }
    }

    @Test
    public void canEnglishBookingsPaidByMoneyWalletBeGotten() {
        statisticsService.getEnglishBookingsPaidByMoneyWallet();
        BookingStatisticVisitor lastStatistic = statisticsService.getLastStatistic();
        Assertions.assertEquals(Language.ENGLISH, lastStatistic.getLanguage());
        Assertions.assertEquals(PaymentType.MONEY_WALLET, lastStatistic.getPaymentType());

        if (lastStatistic.getBookingsCount() > 0) {
            Assertions.assertTrue(lastStatistic.getBookingsValue(Currency.EURO).getAmount() > 0);
        } else {
            Assertions.assertEquals(0, lastStatistic.getBookingsValue(Currency.EURO).getAmount());
        }
    }
}
