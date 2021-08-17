package model;

import view.Language;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookingStatisticVisitor implements ContentVisitor {
    private final Language language;
    private final PaymentType paymentType;
    private List<Booking> bookings;

    public BookingStatisticVisitor(Language language, PaymentType paymentType) {
        this.language = language;
        this.paymentType = paymentType;
        this.bookings = new ArrayList<>();
    }

    @Override
    public void visit(Folder folder) {
        this.bookings = getMatchingBookingsFrom(folder);
    }

    /**
     * Finds and returns all bookings within the given folder that have the specified Language and PaymentType
     * @param folder the that is being searched
     * @return all bookings that were found
     */
    private List<Booking> getMatchingBookingsFrom(Folder folder) {
        List<Booking> foundBookings = new ArrayList<>();

        for (Map.Entry<String, Content> contentEntry: folder.getContents().entrySet()) {
            // 1. Look for BookingFiles within this folder
            // 2. Look for BookingFiles within subfolders

            if (contentEntry.getValue() instanceof BookingFile) {
                Booking booking = ((BookingFile) contentEntry.getValue()).getBooking();
                if (booking.getLanguage() == this.language && booking.getPayment().getPaymentType() == this.paymentType) {
                    // Matching booking found
                    foundBookings.add(booking);
                }
            } else if (contentEntry.getValue() instanceof Folder) {
                // Check all bookings within this folder
                foundBookings.addAll(getMatchingBookingsFrom((Folder) contentEntry.getValue()));
            }
        }

        return foundBookings;
    }

    public List<Booking> getBookings() {
        return this.bookings;
    }

    public int getBookingsCount() {
        return this.bookings.size();
    }

    public CurrencyAmount getBookingsValue(Currency currency) {
        double amount = 0;

        for (Booking booking: bookings) {
            CurrencyAmount bookingValue = booking.getPayment().getCurrencyAmount();
            amount += bookingValue.to(currency).getAmount();
        }

        return new CurrencyAmount(amount, currency);
    }
}
