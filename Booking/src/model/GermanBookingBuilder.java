package model;

public class GermanBookingBuilder extends BookingBuilder {

    @Override
    public void buildHeader() {
        booking.setHeader("Lieber Kunde, Vielen Dank für ihre Reservierung.");
    }

    @Override
    public void buildBody() {
        // TODO: Adjust model.Currency to user settings
        String sb = "Sie haben die folgende Ressource gebucht:" +
                "\n\n" + booking.getResource().getDescription() +
                "\n" + "= Total: " + String.format("%36s", booking.getResource().getPrice()) +
                "\n\n" + String.format("Paid with %s (%s)", booking.getPayment().getPaymentType(), booking.getPayment().getSender().getEmail());
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
