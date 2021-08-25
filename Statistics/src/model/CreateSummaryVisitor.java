package model;

import view.Language;

import java.util.Arrays;
import java.util.Map;

public class CreateSummaryVisitor implements ContentVisitor {

    /**
     * Creates a File that contains a summary of all BookingFiles within the given Folder.
     * Adds this File to the folders contents
     *
     * @param folder the folder the summary will be created for
     */
    @Override
    public void visit(Folder folder) {
        int[][] bookingCounts = new int[PaymentType.values().length][Language.values().length];
        CurrencyAmount[][] paymentAmounts = new CurrencyAmount[PaymentType.values().length][Language.values().length];

        // Fill arrays with initial values
        for (int[] row : bookingCounts)
            Arrays.fill(row, 0);
        for (CurrencyAmount[] row : paymentAmounts)
            Arrays.fill(row, new CurrencyAmount(0.0, Currency.US_DOLLAR)); // TODO: Adjust Currency to user settings


        for (Map.Entry<String, Content> contentEntry : folder.getContents().entrySet()) {
            if (contentEntry.getValue() instanceof Folder) {
                // Content is Folder -> get summary file of subFolder and add contents to summary file
                Folder subFolder = (Folder) contentEntry.getValue();
                SummaryFile summaryFile = subFolder.getSummaryFile();

                if (summaryFile != null) {

                    for (PaymentType paymentType : PaymentType.values()) {
                        // Prevents index out of bounds
                        if (bookingCounts.length < paymentType.ordinal() ||
                                paymentAmounts.length < paymentType.ordinal()) break;

                        for (Language language : Language.values()) {
                            // Prevents index out of bounds
                            if (bookingCounts[paymentType.ordinal()].length < language.ordinal() ||
                                    paymentAmounts[paymentType.ordinal()].length < language.ordinal()) break;

                            bookingCounts[paymentType.ordinal()][language.ordinal()] += summaryFile.getBookingCounts()[paymentType.ordinal()][language.ordinal()];
                            paymentAmounts[paymentType.ordinal()][language.ordinal()] = paymentAmounts[paymentType.ordinal()][language.ordinal()].add(summaryFile.getPaymentAmounts()[paymentType.ordinal()][language.ordinal()]);
                        }
                    }
                }

            } else if (contentEntry.getValue() instanceof BookingFile) {
                // Content is BookingFile -> read file and add data to summary file
                BookingFile bookingFile = (BookingFile) contentEntry.getValue();
                Booking booking = bookingFile.getBooking();

                bookingCounts[booking.getPayment().getPaymentType().ordinal()][booking.getLanguage().ordinal()]++;
                paymentAmounts[booking.getPayment().getPaymentType().ordinal()][booking.getLanguage().ordinal()] = paymentAmounts[booking.getPayment().getPaymentType().ordinal()][booking.getLanguage().ordinal()].add(booking.getPayment().getCurrencyAmount());
            }
        }

        SummaryFile file = new SummaryFile(folder.getName() + "_Summary", bookingCounts, paymentAmounts);

        folder.addSummaryFile(file);
    }
}
