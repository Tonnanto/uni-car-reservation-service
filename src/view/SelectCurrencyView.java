package view;

import controller.CarReservationService;
import controller.Command;
import controller.Config;
import controller.commands.SetCurrencyCommand;
import model.Currency;

import java.util.ArrayList;
import java.util.List;

public class SelectCurrencyView extends SelectionView {

    CarReservationService carReservationService;

    public SelectCurrencyView(CarReservationService carReservationService) {
        this.carReservationService = carReservationService;
    }

    @Override
    protected List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new SetCurrencyCommand(carReservationService, Currency.EURO));
        commands.add(new SetCurrencyCommand(carReservationService, Currency.US_DOLLAR));
        return commands;
    }

    @Override
    protected String getMessage() {
        return Config.resourceBundle.getString("utilities.view.SelectCurrencyView.Message");
    }
}
