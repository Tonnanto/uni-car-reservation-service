package controller;

import model.Person;
import model.PersonFactory;
import model.PersonType;
import view.*;


public class PersonService {


    private boolean personCreated;
    private Person person;


    public Person createPerson() {
        //Loop to get the attributes of a person
        while (!personCreated) {
            //if personType is not chosen yet, choose it
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
            new ShowPersonView(this).display();
            new ConfirmSelectionView(this).display();

        }

        return person;
    }

    //================================================================================
    // Accessors
    //================================================================================

    public Person getPerson() {
        return person;
    }

    public boolean isPersonCreated() {return personCreated;}

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
        personCreated = false;
    }

    public void finishSelection() {
        if (person == null) return;
        personCreated = true;
    }
}