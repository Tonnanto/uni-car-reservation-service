package controller;

import model.BookingFile;
import model.Content;
import model.Folder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class ContentServiceTest {

    private static ContentService contentService;

    @BeforeAll
    protected static void setUp() {
        contentService = new ContentService();
    }

    @Test
    @Order(1)
    protected void canContentBeAdded() {
        // Add some random bookings
        for (int i = 0; i < 50; i++) {
            Assertions.assertTrue(contentService.addContent(new BookingFile(contentService.getRandomBooking())));
        }
    }


    @Test
    @Order(2)
    protected void canContentBeShown() {
        // Test if the whole content hierarchy can be navigated
        contentService.navigateContent();
        Assertions.assertTrue(contentService.isNavigatingContent());

        navigateContent(contentService.getRoot());

        contentService.closeContent();
        Assertions.assertFalse(contentService.isNavigatingContent());
    }

    private void navigateContent(Content content) {
        // Navigate into content
        contentService.openContent(content);
        Assertions.assertEquals(contentService.getNavigationPath().peek(), content.getName());

        // Navigate into all child contents of folder
        if (content instanceof Folder) {
            for (Map.Entry<String, Content> contentEntry : ((Folder) content).getContents().entrySet()) {
                navigateContent(contentEntry.getValue());
            }
        }

        // Navigate back
        contentService.closeContent();
    }
}
