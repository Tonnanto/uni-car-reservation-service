package model;

import view.Language;

public class SummaryFile extends File {


    // Stores the total number of Bookings per language and per payment method
    final int[][] bookingCounts;

    // Stores the total amount payed per language and per payment method
    // TODO: Consider different currencies?
    final CurrencyAmount[][] paymentAmounts;

    public SummaryFile(String name, int[][] bookingCounts, CurrencyAmount[][] paymentAmounts) {
        super(name);

        this.bookingCounts = bookingCounts;
        this.paymentAmounts = paymentAmounts;
    }

    public int[][] getBookingCounts() {
        return bookingCounts;
    }

    public CurrencyAmount[][] getPaymentAmounts() {
        return paymentAmounts;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getName());

        sb.append("\n");
        sb.append(String.format("┌───────────────────────────────────┬──────────┬──────────────┐%n"));
        sb.append(String.format("│ Payment Method         Language   │ Bookings │      Revenue │%n"));
        sb.append(String.format("├───────────────────────────────────┼──────────┼──────────────┤%n"));

        for (PaymentType paymentType : PaymentType.values()) {
            // Prevents index out of bounds
            if (bookingCounts.length < paymentType.ordinal() ||
                    paymentAmounts.length < paymentType.ordinal()) break;

            for (Language language : Language.values()) {
                // Prevents index out of bounds
                if (bookingCounts[paymentType.ordinal()].length < language.ordinal() ||
                        paymentAmounts[paymentType.ordinal()].length < language.ordinal()) break;

                sb.append(
                        String.format(
                                "│ %-22s %-10s │ %8d │ %12s │%n",
                                paymentType,
                                "(" + language.name() + ")",
                                bookingCounts[paymentType.ordinal()][language.ordinal()],
                                paymentAmounts[paymentType.ordinal()][language.ordinal()]
                        )
                );
            }
        }
        sb.append(String.format("└───────────────────────────────────┴──────────┴──────────────┘%n"));

        return sb.toString();
    }
}
