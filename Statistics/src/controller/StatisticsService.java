package controller;

import model.*;

public class StatisticsService implements Observer {

    private Folder contentRootFolder;

    public StatisticsService(Folder contentRootFolder) {
        this.contentRootFolder = contentRootFolder;
        contentRootFolder.addObserver(this);
    }

    // TODO: temporary
    public static void main(String[] args) {
        ContentService contentService = new ContentService();
        StatisticsService statisticsService = new StatisticsService(contentService.getRoot());

        contentService.addContent(new BookingFile());
        contentService.addContent(new BookingFile());
        contentService.addContent(new BookingFile());
        contentService.addContent(new BookingFile());

        statisticsService.getEnglishBookingsPaidByGoogleWallet();

        System.out.println(contentService.getRoot().getSummaryFile());
    }

    public void getGermanBookingsPaidByPayPal() {
        new GetBookingsVisitor(Language.GERMAN, PaymentType.PAYPAL);
    }

    public void getGermanBookingsPaidByGoogleWallet() {
        new GetBookingsVisitor(Language.GERMAN, PaymentType.GOOGLE_WALLET).visit(contentRootFolder);
    }

    public void getGermanBookingsPaidByMoneyWallet() {
        new GetBookingsVisitor(Language.GERMAN, PaymentType.MONEY_WALLET).visit(contentRootFolder);
    }

    public void getEnglishBookingsPaidByPayPal() {
        new GetBookingsVisitor(Language.ENGLISH, PaymentType.PAYPAL).visit(contentRootFolder);
    }

    public void getEnglishBookingsPaidByGoogleWallet() {
        new GetBookingsVisitor(Language.ENGLISH, PaymentType.GOOGLE_WALLET).visit(contentRootFolder);
    }

    public void getEnglishBookingsPaidByMoneyWallet() {
        new GetBookingsVisitor(Language.ENGLISH, PaymentType.MONEY_WALLET).visit(contentRootFolder);
    }


    @Override
    public void update(Object object) {
        if (object instanceof Folder) {
            Folder folder = (Folder) object;
            new CreateSummaryVisitor().visit(folder);
        }
    }
}
