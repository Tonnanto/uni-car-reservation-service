package controller;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void addObservers(List<Observer> observers) {
        this.observers.addAll(observers);
    }

    public List<Observer> getObservers() {
        return this.observers;
    }

    /**
     * should be called to notify observers
     */
    public void setChanged() {
        this.notifyObservers();
    }

    private void notifyObservers() {
        for(Observer observer: observers) {
            observer.update(this);
        }
    }
}
