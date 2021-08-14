package controller;

import model.*;
import view.Language;
import view.SelectStatisticView;

import java.util.Map;

public class StatisticsService implements Observer {

    private Folder contentRootFolder;
    private boolean showingStatistics;

    public StatisticsService(Folder contentRootFolder) {
        this.contentRootFolder = contentRootFolder;
        contentRootFolder.addObserver(this);
        updateAll(contentRootFolder);
    }

    public void getGermanBookingsPaidByPayPal() {
//        new GetBookingsVisitor(Language.GERMAN, PaymentType.PAYPAL);
    }

    public void getGermanBookingsPaidByGoogleWallet() {
//        new GetBookingsVisitor(Language.GERMAN, PaymentType.GOOGLE_WALLET).visit(contentRootFolder);
    }

    public void getGermanBookingsPaidByMoneyWallet() {
//        new GetBookingsVisitor(Language.GERMAN, PaymentType.MONEY_WALLET).visit(contentRootFolder);
    }

    public void getEnglishBookingsPaidByPayPal() {
//        new GetBookingsVisitor(Language.ENGLISH, PaymentType.PAYPAL).visit(contentRootFolder);
    }

    public void getEnglishBookingsPaidByGoogleWallet() {
//        new GetBookingsVisitor(Language.ENGLISH, PaymentType.GOOGLE_WALLET).visit(contentRootFolder);
    }

    public void getEnglishBookingsPaidByMoneyWallet() {
//        new GetBookingsVisitor(Language.ENGLISH, PaymentType.MONEY_WALLET).visit(contentRootFolder);
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

    public void showStatistics() {
        showingStatistics = true;

        while (showingStatistics) {
            new SelectStatisticView(this).display();
        }
    }



    //================================================================================
    // The following methods are being called by their corresponding commands.
    //================================================================================

    public void showStatistic(PaymentType paymentType, Language language) {
        if (language == Language.ENGLISH) {
            switch (paymentType) {
                case PAYPAL -> getEnglishBookingsPaidByPayPal();
                case GOOGLE_WALLET -> getEnglishBookingsPaidByGoogleWallet();
                case MONEY_WALLET -> getEnglishBookingsPaidByMoneyWallet();
            }
        } else if (language == Language.GERMAN) {
            switch (paymentType) {
                case PAYPAL -> getGermanBookingsPaidByPayPal();
                case GOOGLE_WALLET -> getGermanBookingsPaidByGoogleWallet();
                case MONEY_WALLET -> getGermanBookingsPaidByMoneyWallet();
            }
        }
    }
}
