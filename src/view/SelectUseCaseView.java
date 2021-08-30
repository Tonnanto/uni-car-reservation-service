package view;

import controller.CarReservationService;
import controller.Command;
import controller.Config;
import controller.commands.*;

import java.util.ArrayList;
import java.util.List;

public class SelectUseCaseView extends SelectionView {

    private final CarReservationService carReservationService;

    public SelectUseCaseView(CarReservationService carReservationService) {
        this.carReservationService = carReservationService;
    }

    @Override
    protected List<Command> getCommands() {

        List<Command> commands = new ArrayList<>();

        if (carReservationService.getAuthenticationService() == null || !carReservationService.getAuthenticationService().isSubjectAuthenticated()) {
            commands.add(new ShowAllResources(carReservationService));
            commands.add(new CreatePersonCommand(carReservationService));
            if (carReservationService.getPerson() != null && carReservationService.getAuthenticationService() != null)
                commands.add(new AuthenticateSubjectCommand(carReservationService));
        } else {
            commands.add(new ReserveResourceCommand(carReservationService));
            commands.add(new ShowStatisticsCommand(carReservationService));
            commands.add(new ShowContentCommand(carReservationService));
            commands.add(new LogOutCommand(carReservationService));
        }

        commands.add(null);
        commands.add(new PromptConfigCommand(carReservationService));

        return commands;
    }

    @Override
    protected String getMessage() {
        if (carReservationService.getPerson() != null) {
            if (carReservationService.getAuthenticationService() != null && carReservationService.getAuthenticationService().isSubjectAuthenticated())
                return Config.resourceBundle.getString("src.view.SelectUseCaseView.Message1") + " " + carReservationService.getPerson().getName();
            else return Config.resourceBundle.getString("src.view.SelectUseCaseView.Message2") + " " + carReservationService.getPerson().getName() + "\n" + Config.resourceBundle.getString("src.view.SelectUseCaseView.Message3");
        }
        return "";
    }
}
