package model;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class GermanBookingBuilder extends BookingBuilder {

    @Override
    public void buildHeader() {
        String text = booking.getBookingDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(new Locale("de")));
        text += String.format("\n\nSehr geehrter %s, Vielen Dank für ihre Reservierung.", booking.getCustomer().getName());
        booking.setHeader(text);
    }

    @Override
    public void buildBody() {
        // TODO: Adjust model.Currency to user settings
        String sb = "Sie haben die folgende Ressource gebucht:" +
                "\n\n" + booking.getResource().getDescription() +
                "\n" + "= Insgesamt: " + String.format("%32s", booking.getResource().getPrice()) +
                "\n\n" + String.format("Bezahlt mit %s (%s)", booking.getPayment().getPaymentType(), booking.getPayment().getSender().getEmail());
        booking.setBody(sb);
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
