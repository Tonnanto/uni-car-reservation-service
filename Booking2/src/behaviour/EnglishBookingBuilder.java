package behaviour;

public class EnglishBookingBuilder extends BookingBuilder{
    @Override
    public String buildHeader() {
        return "Hello Costumer, Thank you for your reservation.";
    }

    @Override
    public String buildBody() {
        return "Your reserved the following car:";
    }

    @Override
    public void buildFooter() {
        booking.setFooter("If you need further assistance, fell free to contact us. With best regards, Your CarReservationTeam ");
    }
}
