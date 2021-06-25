package behaviour;

import model.PaymentType;
import model.Resource;

public class GermanBookingBuilder extends BookingBuilder {
    public GermanBookingBuilder(Resource resource, PaymentType paymentType) {
        super(resource, paymentType);
    }

    @Override
    public void buildHeader() {
        booking.setHeader("Lieber Kunde, Vielen Dank für ihre Reservierung.");
    }

    @Override
    public void buildBody() {
        booking.setBody("Sie haben folgendes Auto reserviert: "+ booking.getResource().getDescription() +": "+ booking.getResource().getPrice() +"€");
    }

    @Override
    public void buildFooter() {
        booking.setFooter("Bei Fragen stehen wir selbstverständlich zur Verfügung. Mit freundlichen Grüßen Ihr CarReservationTeam");
    }
}
