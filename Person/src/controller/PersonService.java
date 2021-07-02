package controller;

import model.*;
import view.ConfirmSelectionView;
import view.EnterEmailView;
import view.EnterNameView;
import view.SelectPersonTypeView;

import java.util.List;


public class PersonService implements Observer {


    private boolean personCreated;
    private Person person;

//TODO Main methode entfernen
    public static void main(String[] args) {
        new PersonService().createPerson();
    }


    public Person createPerson() {

        while (!personCreated) {
//TODO Comments
            if (person == null) {
                new SelectPersonTypeView(this).display();
                continue;
            }
            if (person.getName() == null || person.getName().isEmpty()) {
                new EnterNameView(this).display();
                continue;
            }
            if (person.getEmail() == null || person.getEmail().isEmpty()) {
                new EnterEmailView(this).display();
                continue;
            }

            new ConfirmSelectionView(this).display();

        }

        return person;
    }


    @Override
    public void update(Object object) {

    }


    //================================================================================
    // The following methods are being called by their corresponding commands.
    //================================================================================

    public void selectPersonType(PersonType personType) {
        person = PersonFactory.createPerson(personType);
    }

    public void setName(String name) {
        person.setName(name);
    }

    public void setEmail(String email) {
        person.setEmail(email);
    }

    public void resetSelection() {
        person = null;
    }

    public void finishSelection() {
        if (person == null) return;
        personCreated = true;
    }
}