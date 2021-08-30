package controller;

import model.*;
import model.decorator.*;
import view.*;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
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

    // TODO: temp method
//    public static void main(String[] args) {
//        ContentService cs = new ContentService();

        // Adding test content
//        cs.addContent(new BookingFile(), LocalDate.of(2017, 1, 1));
//        cs.addContent(new BookingFile(), LocalDate.of(2017, 5, 23));
//        cs.addContent(new BookingFile(), LocalDate.of(2018, 12, 31));
//        cs.addContent(new BookingFile(), LocalDate.of(2018, 12, 31));
//        cs.addContent(new BookingFile());
//        cs.addContent(new BookingFile());
//        cs.addContent(new BookingFile());
//        cs.addContent(new BookingFile());
//        cs.addContent(new BookingFile());
//        cs.addContent(new BookingFile());

//        cs.addDemoBookings(100);

        // triggering UseCase: showContent

//        cs.showContent();
//    }

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
     * @param date    the date at which the content should be added
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
        showingContent = true;
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


    //================================================================================
    // DEMO Data
    //================================================================================

    /**
     * Adds demo BookingFiles to this content hierarchy.
     * The Data added is randomly generated and will be different each time this method gets called.
     * It is only used for demonstration and testing purposes
     * @param bookingCount the amount of bookings to add
     */
    public void addDemoBookings(int bookingCount) {
        Random r = new Random();

        for (int i = 0; i < bookingCount; i++) {
            int randomYear = 2016 + r.nextInt(5);
            int randomMonth = 1 + r.nextInt(11);
            int randomDay = 1 + r.nextInt(28);

            addContent(new BookingFile(getRandomBooking()), LocalDate.of(randomYear, randomMonth, randomDay));
        }
    }

    private Booking getRandomBooking() {
        Random r = new Random();
        BookingBuilder bb = r.nextBoolean() ? new GermanBookingBuilder() : new EnglishBookingBuilder();
        BookingDirector bd = new BookingDirector(bb);

        Resource randomResource = getRandomResource();
        Payment randomPayment = getRandomPayment(randomResource);

        bd.createBooking(randomResource, randomPayment);
        return bd.getBooking();
    }

    private Resource getRandomResource() {
        Random r = new Random();
        List<Car> availableCars = new ResourceService().getAvailableCars();
        Resource randomResource = availableCars.get(r.nextInt(availableCars.size()));

        for (int i = 0; i < r.nextInt(10); i++) {
            CarDecoratorType cdt = CarDecoratorType.values()[r.nextInt(CarDecoratorType.values().length)];
            switch (cdt) {
                case SET_TOP_BOX -> randomResource = new SetTopBox(randomResource);
                case CHILD_SEAT -> randomResource = new ChildSeat(randomResource);
                case AMBIENCE_LIGHTING -> randomResource = new AmbienceLighting(randomResource);
                case MAGIC_TREE -> randomResource = new MagicTree(randomResource);
                case WINDOW_SHADE -> randomResource = new WindowShade(randomResource);
            }
        }

        return randomResource;
    }

    private Payment getRandomPayment(Resource resource) {
        Random r = new Random();

        String[] emails = {"anton@stamme.de", "jonas@harms.de", "ram@mo.de", "max.mustermann@gmail.com"};
        String randomSender = emails[r.nextInt(emails.length)];

        Payment payment = null;
        PaymentType paymentType = PaymentType.values()[r.nextInt(PaymentType.values().length)];

        switch (paymentType) {
            case PAYPAL -> payment = new PayPalPayment(resource.getPrice());
            case GOOGLE_WALLET -> payment = new GoogleWalletPayment(resource.getPrice());
            case MONEY_WALLET -> payment = new MoneyWalletPayment(resource.getPrice());
        }
        payment.authenticateCustomer(randomSender, "password420");

        return payment;
    }
}
