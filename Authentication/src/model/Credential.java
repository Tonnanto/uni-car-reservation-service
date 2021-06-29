package model;

import controller.Observable;

public abstract class Credential extends Observable {
   public abstract boolean authenticate(Subject subject);
}
