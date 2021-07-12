package controller;

import model.Folder;

public class StatisticsService implements Observer {

    private Folder contentRootFolder;

    public void getGermanBookingsPaidByPayPal() {
        // TODO: let GetBookingsVisitor visit contentRootFolder
    }

    public void getGermanBookingsPaidByGoogleWallet() {
        // TODO: let GetBookingsVisitor visit contentRootFolder
    }

    public void getGermanBookingsPaidByMoneyWallet() {
        // TODO: let GetBookingsVisitor visit contentRootFolder
    }

    public void getEnglishBookingsPaidByPayPal() {
        // TODO: let GetBookingsVisitor visit contentRootFolder
    }

    public void getEnglishBookingsPaidByGoogleWallet() {
        // TODO: let GetBookingsVisitor visit contentRootFolder
    }

    public void getEnglishBookingsPaidByMoneyWallet() {
        // TODO: let GetBookingsVisitor visit contentRootFolder
    }


    @Override
    public void update(Object object) {
        if (object instanceof Folder) {
            Folder folder = (Folder) object;
            // TODO: let CreateSummaryVisitor visit folder
        }
    }
}
