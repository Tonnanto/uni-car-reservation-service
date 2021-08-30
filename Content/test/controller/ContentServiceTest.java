package controller;

import model.BookingFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ContentServiceTest {

    private static ContentService contentService;

    @BeforeAll
    protected static void setUp() {
        contentService = new ContentService();
    }

    @Test
    protected void canContentBeAdded() {


        for (int i = 0; i < 50; i++) {
            Assertions.assertTrue(contentService.addContent(new BookingFile(contentService.getRandomBooking())));
        }

//        BookingDirector bookingDirector = new BookingDirector(new EnglishBookingBuilder());
//        bookingDirector.createBooking(new Car(""), payment);
//
//        // Adding test files to hierarchy
//        Assertions.assertTrue(contentService.addContent(new BookingFile(), LocalDate.of(2017, 1, 1)));
//        Assertions.assertTrue(contentService.addContent(new BookingFile(), LocalDate.of(2017, 5, 23)));
//        Assertions.assertTrue(contentService.addContent(new BookingFile(), LocalDate.of(2018, 12, 31)));
//        Assertions.assertTrue(contentService.addContent(new BookingFile(), LocalDate.of(2018, 12, 31)));
//
//        Assertions.assertTrue(contentService.addContent(new BookingFile()));
//        Assertions.assertTrue(contentService.addContent(new BookingFile()));
//        Assertions.assertTrue(contentService.addContent(new BookingFile()));
//        Assertions.assertTrue(contentService.addContent(new BookingFile()));
//        Assertions.assertTrue(contentService.addContent(new BookingFile()));
//        Assertions.assertTrue(contentService.addContent(new BookingFile()));
    }


    @Test
    protected void canContentBeShown() {

    }

    @Test
    protected void cantSameFilesBeAdded() {
//        Assertions.assertTrue(contentService.addContent(new BookingFile("Booking_abc")));
//        // Files with same name can't be added to the same Folder
//        Assertions.assertFalse(contentService.addContent(new BookingFile("Booking_abc")));
    }
}
