package controller;

import model.*;

import java.util.Map;

public class StatisticsService implements Observer {

    private Folder contentRootFolder;

    public StatisticsService(Folder contentRootFolder) {
        this.contentRootFolder = contentRootFolder;
        contentRootFolder.addObserver(this);
        updateAll(contentRootFolder);
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

    /**
     * Updates the given folder and all of it's subfolders
     * @param folder the folder to update
     */
    private void updateAll(Folder folder) {
        for (Map.Entry<String, Content> contentEntry: folder.getContents().entrySet()) {
            if (contentEntry.getValue() instanceof Folder) {
                updateAll((Folder) contentEntry.getValue());
            }
        }
        update(folder);
    }
}
