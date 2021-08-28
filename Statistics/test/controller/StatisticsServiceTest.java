package controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StatisticsServiceTest {

    private static ContentService contentService;
    private static StatisticsService statisticsService;

    @BeforeAll
    protected static void setUp() {
        contentService = new ContentService();
        statisticsService = new StatisticsService(contentService.getRoot());
    }

    @Test
    protected void canSummaryBeCreated() {

//        contentService.addContent(new BookingFile());
//        contentService.addContent(new BookingFile());
//        contentService.addContent(new BookingFile());
//        contentService.addContent(new BookingFile());
//
//        statisticsService.getEnglishBookingsPaidByGoogleWallet();
//
//        System.out.println(contentService.getRoot().getSummaryFile());

        // TODO: some assertions
    }

    @Test
    protected void canBookingsBeGotten() {

    }
}
