package controller;

import model.BookingFile;
import model.Content;
import model.File;
import model.Folder;
import view.*;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.Stack;

/**
 * Manages a Content hierarchy where BookingFiles are stored in Folders.
 * The root Folder contains Folders of years which contain Folders of months.
 * Each year- and month Folder also contains a SummaryFile which summarizes the Bookings within this Folder.
 */
public class ContentService {

    private final Folder root;

    private boolean showingContent = true;
    private boolean navigatingContent;
    private Stack<String> navigationPath;

    public ContentService() {
        this.root = new Folder("Bookings");
    }

    public static void main(String[] args) {
        ContentService cs = new ContentService();

        // Adding test content
        cs.addContent(new BookingFile(), LocalDate.of(2017, 1, 1));
        cs.addContent(new BookingFile(), LocalDate.of(2017, 5, 23));
        cs.addContent(new BookingFile(), LocalDate.of(2018, 12, 31));
        cs.addContent(new BookingFile(), LocalDate.of(2018, 12, 31));
        cs.addContent(new BookingFile());
        cs.addContent(new BookingFile());
        cs.addContent(new BookingFile());
        cs.addContent(new BookingFile());
        cs.addContent(new BookingFile());
        cs.addContent(new BookingFile());

        // triggering UseCase: showContent

        cs.showContent();
    }

    /**
     * Adds Content to the hierarchy. Uses the current date to determine the correct location.
     * Represents the UseCase "addContent"
     *
     * @param content the content to add
     * @return whether the operation was successful
     */
    public boolean addContent(Content content) {
        return addContent(content, LocalDate.now());
    }

    /**
     * Adds Content to the hierarchy according to the specified date.
     *
     * @param content the content that should be added
     * @param date the date at which the content should be added
     * @return whether the operation was successful
     */
    public boolean addContent(Content content, LocalDate date) {
        String year = "" + date.getYear();
        String month = (new DateFormatSymbols().getMonths())[date.getMonthValue() - 1];

        return this.root.addContent(content, year, month);
    }

    /**
     * Represents the UseCase "showContent"
     */
    public void showContent() {
        while (showingContent) {
            // Let user select between "Show entire content hierarchy" and "Navigate Content"
            new SelectShowMethodView(this).display();

            // only enters loop if "Navigate Content" has been selected
            while (navigatingContent) {
                if (navigationPath.size() <= 0) {
                    new ShowFolderView(this, root).display();

                } else {
                    Content contentToShow = root.findContentWithPath(navigationPath.toArray(new String[0]));

                    if (contentToShow == null) {
                        new ContentNotFoundView().display();

                    } else if (contentToShow instanceof Folder) {
                        new ShowFolderView(this, (Folder) contentToShow).display();

                    } else {
                        new ShowFileView(this, (File) contentToShow).display();
                    }
                }
            }
        }
    }

    //================================================================================
    // Accessors
    //================================================================================

    public Folder getRoot() {
        return this.root;
    }

    public Stack<String> getNavigationPath() {
        return navigationPath;
    }

    //================================================================================
    // The following methods are being called by their corresponding commands.
    //================================================================================

    public void showContentHierarchy() {
        new ShowContentHierarchyView(this).display();
    }

    public void navigateContent() {
        navigatingContent = true;
        navigationPath = new Stack<>();
    }

    public void openContent(Content content) {
        navigationPath.push(content.getName());
    }

    public void closeContent() {
        if (navigationPath != null && navigationPath.size() > 0)
            navigationPath.pop();
        else
            navigatingContent = false;
    }

    public void cancel() {
        navigatingContent = false;
        showingContent = false;
    }
}
