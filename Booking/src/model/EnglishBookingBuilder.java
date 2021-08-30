package model;

import controller.Config;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class EnglishBookingBuilder extends BookingBuilder {


    @Override
    public void buildHeader() {
        String text = booking.getBookingDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(new Locale("en")));
        text += String.format("\n\nHello %s, Thank you for your reservation.", booking.getCustomer().getName());
        booking.setHeader(text);
    }

    @Override
    public void buildBody() {
        String sb = "You have booked the following Resource:" +
                "\n\n" + booking.getResource().getDescription() +
                "\n" + "= Total: " + String.format("%36s", booking.getResource().getPrice().to(Config.currency)) +
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
