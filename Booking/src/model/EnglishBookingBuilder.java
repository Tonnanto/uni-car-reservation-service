package model;

import view.Language;

public class EnglishBookingBuilder extends BookingBuilder {


    @Override
    public void buildHeader() {
        booking.setHeader("Hello Costumer, Thank you for your reservation.");
    }

    @Override
    public void buildBody() {
        booking.setBody("Your reserved the following car: " + booking.getResource().getDescription() + ": " + booking.getResource().getPrice() + "€");
    }

    @Override
    public void buildFooter() {
        booking.setFooter("If you need further assistance, fell free to contact us. With best regards, Your CarReservationTeam ");
    }

    @Override
    public void buildLanguage() {
        booking.setLanguage(Language.ENGLISH);
    }
}
