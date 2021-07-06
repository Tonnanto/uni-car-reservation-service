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

    public static void main(String[] args) {
        new PersonService().createPerson();
    }


    public Person createPerson() {
//Loop to get the attributes of a person
        while (!personCreated) {
            //if persontype is not chosen yet, choose it
            if (person == null) {
                new SelectPersonTypeView(this).display();
                continue;
            }
            //if name is not set, input the name
            if (person.getName() == null || person.getName().isEmpty()) {
                new EnterNameView(this).display();
                continue;
            }
            // if e-mail is not set, input the name
            if (person.getEmail() == null || person.getEmail().isEmpty()) {
                new EnterEmailView(this).display();
                continue;
            }
            // let the client restart or confirm his choice
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