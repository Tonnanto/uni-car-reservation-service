package controller.commands;

import controller.CarReservationService;
import model.Currency;

public class SetCurrencyCommand extends CarReservationCommand {

    final private Currency currency;

    public SetCurrencyCommand(CarReservationService carReservationService, Currency currency) {
        super(carReservationService);
        this.currency = currency;
    }

    @Override
    public void execute() {
        receiver.setCurrency(currency);
    }

    @Override
    public String getDescription() {
        return currency.toName();
    }
}
