package model;

import view.Language;

public class GermanBookingBuilder extends BookingBuilder {

    @Override
    public void buildHeader() {
        booking.setHeader("Lieber Kunde, Vielen Dank für ihre Reservierung.");
    }

    @Override
    public void buildBody() {
        booking.setBody("Sie haben folgendes Auto reserviert: " + booking.getResource().getDescription() + ": " + booking.getResource().getPrice() + "€");
    }

    @Override
    public void buildFooter() {
        booking.setFooter("Bei Fragen stehen wir selbstverständlich zur Verfügung. Mit freundlichen Grüßen Ihr CarReservationTeam");
    }

    @Override
    public void buildLanguage() {
        booking.setLanguage(Language.GERMAN);
    }
}
