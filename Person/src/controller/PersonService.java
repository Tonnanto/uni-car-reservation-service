package controller;

import model.Person;
import model.PersonType;
import view.ConfirmSelectionView;
import view.EnterEmailView;
import view.EnterNameView;
import view.SelectPersonTypeView;

import java.util.List;

/**
 * Manages the selection process and the creation of a resource (car).
 */
public class PersonService implements Observer {


    private boolean personCreated;
    private Person person;


    public static void main(String[] args) {
        new PersonService().createPerson();
    }

    /**
     * Creates and returns a resource according to the selections of a user.
     * Different Views are being displayed in order to receive user input.
     *
     * @return the selected resource
     */

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

    /**
     * Is being called whenever the associated Observables call .setChanged()
     *
     * @param object the object that changed
     */
    @Override
    public void update(Object object) {

    }



    //================================================================================
    // Accessors
    //================================================================================


    //================================================================================
    // The following methods are being called by their corresponding commands.
    //================================================================================

    public void setName(String name) {
    }

    public void selectPersonType(PersonType personType) {
    }
}