package behaviour;

public class GermanBookingBuilder extends BookingBuilder {
    @Override
    public void buildHeader() {
        booking.setHeader("Lieber Kunde, Vielen Dank für ihre Reservierung.");
    }

    @Override
    public void buildBody() {
        booking.setBody("Sie haben folgendes Auto reserviert: ");
    }

    @Override
    public void buildFooter() {
        booking.setFooter("Bei Fragen stehen wir selbstverständlich zur Verfügung. Mit freundlichen Grüßen Ihr CarReservationTeam");
    }
}
