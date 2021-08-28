package controller;

import model.Currency;

import java.util.ResourceBundle;

public class Config {
    public static ResourceBundle resourceBundle =
            ResourceBundle.getBundle("view.Bundle");
    public static Currency currency = Currency.EURO;
}
