package controller;

import model.BookingFile;
import model.Content;
import model.Folder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Map;

public class ContentServiceTest {

    private static ContentService contentService;

    @BeforeAll
    protected static void setUp() {
        contentService = new ContentService();
    }

    @AfterAll
    protected static void tearDown() {
        // Outputting hierarchy to console
        System.out.println(contentService.getRoot());
    }

    @Test
    protected void canContentBeAdded() {

        // Adding test files to hierarchy
        Assertions.assertTrue(contentService.addContent(new BookingFile(), LocalDate.of(2017, 1, 1)));
        Assertions.assertTrue(contentService.addContent(new BookingFile(), LocalDate.of(2017, 5, 23)));
        Assertions.assertTrue(contentService.addContent(new BookingFile(), LocalDate.of(2018, 12, 31)));
        Assertions.assertTrue(contentService.addContent(new BookingFile(), LocalDate.of(2018, 12, 31)));

        Assertions.assertTrue(contentService.addContent(new BookingFile()));
        Assertions.assertTrue(contentService.addContent(new BookingFile()));
        Assertions.assertTrue(contentService.addContent(new BookingFile()));
        Assertions.assertTrue(contentService.addContent(new BookingFile()));
        Assertions.assertTrue(contentService.addContent(new BookingFile()));
        Assertions.assertTrue(contentService.addContent(new BookingFile()));
    }

    @Test
    protected void cantSameFilesBeAdded() {
        Assertions.assertTrue(contentService.addContent(new BookingFile("Booking_abc")));
        // Files with same name can't be added to the same Folder
        Assertions.assertFalse(contentService.addContent(new BookingFile("Booking_abc")));
    }

    @Test
    protected void areSummaryFilesBeingCreated() {
        Folder root = contentService.getRoot();
        Assertions.assertNotNull(root.getContent(root.getName() + "_Summary"));

        for (Map.Entry<String, Content> yearEntry : root.getContents().entrySet()) {
            if (yearEntry.getValue() instanceof Folder) {
                Folder yearFolder = (Folder) yearEntry.getValue();
                Assertions.assertNotNull(yearFolder.getContent(yearFolder.getName() + "_Summary"));

                for (Map.Entry<String, Content> monthEntry : yearFolder.getContents().entrySet()) {
                    if (monthEntry.getValue() instanceof Folder) {
                        Folder monthFolder = (Folder) monthEntry.getValue();
                        Assertions.assertNotNull(monthFolder.getContent(monthFolder.getName() + "_Summary"));
                    }
                }
            }
        }
    }
}
