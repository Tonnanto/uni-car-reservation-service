package controller.commands;

import controller.CarReservationService;

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
        if (receiver.getPerson() == null) return "Sign up";
        return "Change Person";
    }
}
