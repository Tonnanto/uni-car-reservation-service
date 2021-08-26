package controller.commands;

import controller.CarReservationService;
import controller.Config;

public class CreatePersonCommand extends CarReservationCommand {

    public CreatePersonCommand(CarReservationService carReservationService) {
        super(carReservationService);
    }

    @Override
    public void execute() {
        receiver.createPerson();
    }

    @Override
    public String getDescription() {
        if (receiver.getPerson() == null) return Config.resourceBundle.getString("src.controller.commands.CreatePersonCommand.Description1");
        return Config.resourceBundle.getString("src.controller.commands.CreatePersonCommand.Description2");
    }
}
