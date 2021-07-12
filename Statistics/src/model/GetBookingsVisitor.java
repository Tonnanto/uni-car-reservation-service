package model;

public class GetBookingsVisitor implements StatisticsVisitor {
    private String language; // TODO Change to Language enum from Booking
    private PaymentType paymentType;

    public GetBookingsVisitor(String language, PaymentType paymentType) {
        this.language = language;
        this.paymentType = paymentType;
    }

    @Override
    public void visit(Folder folder) {
        // TODO: Get Bookings from Folder and display in View
    }
}
