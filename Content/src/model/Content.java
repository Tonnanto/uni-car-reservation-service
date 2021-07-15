package model;

import controller.Observable;

public abstract class Content extends Observable {
    private final String name;

    public Content(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
