package behaviour;

public class GermanBookingBuilder extends BookingBuilder{
    @Override
    public String buildHeader() {
        return "Lieber Kunde, Vielen Dank für ihre Reservierung.";
    }

    @Override
    public String buildBody() {
        return "Sie haben folgendes Auto reserviert: ";
    }

    @Override
    public String buildFooter() {
        return "Bei Fragen stehen wir selbstverständlich zur Verfügung. Mit freundlichen Grüßen Ihr CarReservationTeam";
    }
}
