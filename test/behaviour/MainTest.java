package behaviour;

import controller.CarReservationService;
import view.Language;

import java.util.Locale;
import java.util.ResourceBundle;

public class MainTest {

    public static void main(String[] args) {
        // TODO: Prompt User to select language
        Language.resourceBundle = ResourceBundle.getBundle("view.Bundle", new Locale("en"));
        new CarReservationService().selectUseCase();
    }

}
