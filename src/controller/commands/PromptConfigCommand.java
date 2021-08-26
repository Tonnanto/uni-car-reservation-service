package controller.commands;

import controller.CarReservationService;

public class PromptConfigCommand extends CarReservationCommand {
    public PromptConfigCommand(CarReservationService carReservationService) {
        super(carReservationService);
    }

    @Override
    public void execute() {
        receiver.promptConfig();
    }

    @Override
    public String getDescription() {
        return "Change Language and Currency";
    }
}
