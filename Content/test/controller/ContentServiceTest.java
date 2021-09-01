package controller;

import controller.commands.CloseContentCommand;
import controller.commands.NavigateContentCommand;
import controller.commands.OpenContentCommand;
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
        new NavigateContentCommand(contentService).execute();
        Assertions.assertTrue(contentService.isNavigatingContent());

        navigateContent(contentService.getRoot());

        new CloseContentCommand(contentService).execute();
        Assertions.assertFalse(contentService.isNavigatingContent());
    }

    private void navigateContent(Content content) {
        // Navigate into content
        new OpenContentCommand(contentService, content).execute();
        Assertions.assertEquals(contentService.getNavigationPath().peek(), content.getName());

        // Navigate into all child contents of folder
        if (content instanceof Folder) {
            for (Map.Entry<String, Content> contentEntry : ((Folder) content).getContents().entrySet()) {
                navigateContent(contentEntry.getValue());
            }
        }

        // Navigate back
        new CloseContentCommand(contentService).execute();
    }
}
