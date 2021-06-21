package controller;

import model.Content;
import model.Folder;

import java.text.DateFormatSymbols;
import java.time.LocalDate;

/**
 * Manages a Content hierarchy where BookingFiles are stored in Folders.
 * The root Folder contains Folders of years which contain Folders of months.
 * Each year- and month Folder also contains a SummaryFile which summarizes the Bookings within this Folder.
 */
public class ContentService {

    private final Folder root;

    public ContentService() {
        this.root = new Folder("Bookings");
    }

    public boolean addContent(Content content) {
        return addContent(content, LocalDate.now());
    }

    /**
     * Adds Content to the hierarchy according to the specified date-
     * @param content the content that should be added
     * @param date the date at which the content should be added
     * @return whether the operation was successful
     */
    public boolean addContent(Content content, LocalDate date) {
        String year = "" + date.getYear();
        String  month = (new DateFormatSymbols().getMonths())[date.getMonthValue() - 1];

        return this.root.addContent(content, year, month);
    }

    public Folder getRoot() {
        return this.root;
    }
}
