package controller;

import model.*;
import view.SelectStatisticView;
import view.ShowStatisticView;

import java.util.Map;

public class StatisticsService implements Observer {

    private final Folder contentRootFolder;
    private boolean showingStatistics;

    private BookingStatisticVisitor lastStatistic;

    public StatisticsService(Folder contentRootFolder) {
        this.contentRootFolder = contentRootFolder;
        contentRootFolder.addObserver(this);
        updateAll(contentRootFolder);
    }

    // The following 6 methods are only separated because of a requirement in the task
    public void getGermanBookingsPaidByPayPal() {
        BookingStatisticVisitor germanPayPalVisitor = new BookingStatisticVisitor(Language.GERMAN, PaymentType.PAYPAL);
        this.contentRootFolder.accept(germanPayPalVisitor);
        lastStatistic = germanPayPalVisitor;
    }

    public void getGermanBookingsPaidByGoogleWallet() {
        BookingStatisticVisitor germanPayPalVisitor = new BookingStatisticVisitor(Language.GERMAN, PaymentType.GOOGLE_WALLET);
        this.contentRootFolder.accept(germanPayPalVisitor);
        lastStatistic = germanPayPalVisitor;
    }

    public void getGermanBookingsPaidByMoneyWallet() {
        BookingStatisticVisitor germanPayPalVisitor = new BookingStatisticVisitor(Language.GERMAN, PaymentType.MONEY_WALLET);
        this.contentRootFolder.accept(germanPayPalVisitor);
        lastStatistic = germanPayPalVisitor;
    }

    public void getEnglishBookingsPaidByPayPal() {
        BookingStatisticVisitor germanPayPalVisitor = new BookingStatisticVisitor(Language.ENGLISH, PaymentType.PAYPAL);
        this.contentRootFolder.accept(germanPayPalVisitor);
        lastStatistic = germanPayPalVisitor;
    }

    public void getEnglishBookingsPaidByGoogleWallet() {
        BookingStatisticVisitor germanPayPalVisitor = new BookingStatisticVisitor(Language.ENGLISH, PaymentType.GOOGLE_WALLET);
        this.contentRootFolder.accept(germanPayPalVisitor);
        lastStatistic = germanPayPalVisitor;
    }

    public void getEnglishBookingsPaidByMoneyWallet() {
        BookingStatisticVisitor germanPayPalVisitor = new BookingStatisticVisitor(Language.ENGLISH, PaymentType.MONEY_WALLET);
        this.contentRootFolder.accept(germanPayPalVisitor);
        lastStatistic = germanPayPalVisitor;
    }


    @Override
    public void update(Object object) {
        if (object instanceof Folder) {
            Folder folder = (Folder) object;
            new CreateSummaryVisitor().visit(folder);
        }
    }

    /**
     * Updates the given folder and all of it's sub folders
     *
     * @param folder the folder to update
     */
    private void updateAll(Folder folder) {
        for (Map.Entry<String, Content> contentEntry : folder.getContents().entrySet()) {
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
    // Accessors
    //================================================================================

    public BookingStatisticVisitor getLastStatistic() {
        return lastStatistic;
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

        new ShowStatisticView(this).display();
    }

    public void finishShowingStatistics() {
        showingStatistics = false;
    }
}
