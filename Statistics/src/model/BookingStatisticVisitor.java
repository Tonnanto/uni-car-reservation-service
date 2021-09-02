package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This Visitor has two parameters: language and paymentType.
 * When visiting a Folder it scans the folder for all bookings that have the specified language and paymentType.
 * The found Bookings are being stored in the bookings field and can be accessed for later use.
 */
public class BookingStatisticVisitor implements ContentVisitor {

    private final Language language;
    private final PaymentType paymentType;
    private List<BookingFile> bookingFiles;

    public BookingStatisticVisitor(Language language, PaymentType paymentType) {
        this.language = language;
        this.paymentType = paymentType;
        this.bookingFiles = new ArrayList<>();
    }

    @Override
    public void visit(Folder folder) {
        this.bookingFiles = getMatchingBookingFilesFrom(folder);
    }

    /**
     * Finds and returns all bookingFiles within the given folder that have the specified Language and PaymentType
     *
     * @param folder the that is being searched
     * @return all bookingFiles that were found
     */
    private List<BookingFile> getMatchingBookingFilesFrom(Folder folder) {
        List<BookingFile> foundBookings = new ArrayList<>();

        for (Map.Entry<String, Content> contentEntry : folder.getContents().entrySet()) {
            // 1. Look for BookingFiles within this folder
            // 2. Look for BookingFiles within sub folders

            if (contentEntry.getValue() instanceof BookingFile) {
                BookingFile bookingFile = (BookingFile) contentEntry.getValue();
                if (bookingFile.getBooking().getLanguage() == this.language && bookingFile.getBooking().getPayment().getPaymentType() == this.paymentType) {
                    // Matching booking found
                    foundBookings.add(bookingFile);
                }
            } else if (contentEntry.getValue() instanceof Folder) {
                // Check all bookings within this folder
                foundBookings.addAll(getMatchingBookingFilesFrom((Folder) contentEntry.getValue()));
            }
        }

        return foundBookings;
    }

    public Language getLanguage() {
        return language;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public List<BookingFile> getBookingFiles() {
        return this.bookingFiles;
    }

    public int getBookingsCount() {
        return this.bookingFiles.size();
    }

    public CurrencyAmount getBookingsValue(Currency currency) {
        double amount = 0;

        for (BookingFile bookingFile : bookingFiles) {
            CurrencyAmount bookingValue = bookingFile.getBooking().getPayment().getCurrencyAmount();
            amount += bookingValue.to(currency).getAmount();
        }

        return new CurrencyAmount(amount, currency);
    }
}
