package model;

import view.Language;

public class EnglishBookingBuilder extends BookingBuilder {


    @Override
    public void buildHeader() {
        booking.setHeader("Hello Costumer, Thank you for your reservation.");
    }

    @Override
    public void buildBody() {
        // TODO: Adjust model.Currency to user settings
        String sb = "You have booked the following Resource:" +
                "\n\n" + booking.getResource().getDescription() +
                "\n" + "= Total: " + String.format("%36s", booking.getResource().getPrice()) +
                "\n\n" + String.format("Paid with %s (%s)", booking.getPayment().getPaymentType(), booking.getPayment().getSender().getEmail());
        booking.setBody(sb);
    }

    @Override
    public void buildFooter() {
        booking.setFooter("If you need further assistance, feel free to contact us. \nWith best regards, Your CarReservationTeam!");
    }

    @Override
    public void buildLanguage() {
        booking.setLanguage(Language.ENGLISH);
    }
}
