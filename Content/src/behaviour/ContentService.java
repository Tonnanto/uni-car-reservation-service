package behaviour;

import structure.Content;
import structure.Folder;

import java.text.DateFormatSymbols;
import java.time.LocalDate;

public class ContentService {

    private final Folder root;

    public ContentService() {
        this.root = new Folder("Bookings");
    }

    public boolean addContent(Content content) {
        return addContent(content, LocalDate.now());
    }

    public boolean addContent(Content content, LocalDate date) {
        String year = "" + date.getYear();
        String  month = (new DateFormatSymbols().getMonths())[date.getMonthValue() - 1];

        return this.root.addContent(content, year, month);
    }

    public Folder getRoot() {
        return this.root;
    }
}
