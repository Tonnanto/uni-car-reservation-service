package controller;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {
        Config.resourceBundle = ResourceBundle.getBundle("view.Bundle", new Locale("en"));
        new CarReservationService().selectUseCase();
    }
}
