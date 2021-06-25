package view;

import controller.Command;

import java.util.Scanner;

public abstract class StringInputView extends View {

    /**
     * This method displays the view, reads the user input, and executes the given command.
     */
    @Override
    public void display() {
        // display view
        super.display();

        // read user input
        String inputString = readStringInput();

        System.out.println("String entered: " + inputString);
        // execute command
        Command command = getCommand();
        if (command == null) return;

        command.execute(inputString);
    }

    /**
     * @return the command that should be executed on user input
     */
    protected abstract Command getCommand();

    /**
     * Reads a String from the console.
     * Only accepts String values that conform to isValidString.
     *
     * @return the selected integer value
     */
    protected String readStringInput() {
        System.out.print(inputPrefix);
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()) {

            String enteredString = scanner.nextLine();

            if (enteredString.isEmpty() || !isValidString(enteredString)) {
                // input String is not valid
                System.out.println(getValidationMessage());
                System.out.print(inputPrefix);
                continue;
            }

            // input number is valid
            return enteredString;
        }

        // this return statement should never be reached. null indicates an error
        return null;
    }

    /**
     * Override this method to validate the input String.
     * Always returns true by default.
     *
     * @param s the input String that should be validated
     * @return whether the String is valid
     */
    protected boolean isValidString(String s) {
        return true;
    }

    /**
     * Override this method to use a custom message when an invalid String has been entered.
     * @return the validation message
     */
    protected String getValidationMessage() {
        return "Please enter a valid String.";
    }
}
