package model;

import controller.AuthenticationService;
import controller.Observable;

public abstract class Credential extends Observable {

   public Credential(AuthenticationService authenticationService) {
      this.addObserver(authenticationService);
      this.setChanged();
   }

   public abstract boolean authenticate(Subject subject);
}
