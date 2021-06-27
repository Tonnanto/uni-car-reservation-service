package model;

import controller.Observable;

public abstract class Resource extends Observable {
    public abstract double getPrice();
    public abstract String getDescription();
}
