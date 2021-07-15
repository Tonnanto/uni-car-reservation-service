package model;

public class GetBookingsVisitor implements ContentVisitor {
    private Language language;
    private PaymentType paymentType;

    public GetBookingsVisitor(Language language, PaymentType paymentType) {
        this.language = language;
        this.paymentType = paymentType;
    }

    @Override
    public void visit(Folder folder) {
        System.out.println(folder);
        // TODO: Get Bookings from Folder and display in View
    }
}
