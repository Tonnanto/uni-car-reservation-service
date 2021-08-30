package controller;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {
        // TODO: Prompt User to select language
        Config.resourceBundle = ResourceBundle.getBundle("view.Bundle", new Locale("en"));
        new CarReservationService().selectUseCase();
    }

}
