package view;

import controller.Command;
import controller.Config;

import java.util.Scanner;

/**
 * This View allows the user to enter a String.
 * The entered String can be validated and will be handed to a command.
 */
public abstract class StringInputView extends View {

    private final static Character cancelCharacter = 'X';

    /**
     * This method displays the view, reads the user input, and executes the given command.
     */
    @Override
    public void display() {
        // display view
        System.out.println(separator);
        if (getCancelCommand() != null)
            System.out.printf("[%s] %s\n", cancelCharacter, getCancelCommand().getDescription());
        System.out.println(getMessage());

        // read user input
        String inputString = readStringInput();
        if (inputString == null) return;

        // execute command
        Command command = getCommand(inputString);
        if (command == null) return;

        command.execute();
    }

    /**
     * @return the command that should be executed on user input
     */
    protected abstract Command getCommand(String inputString);

    /**
     * Override this method to decide if the user should have the option to cancel the input.
     *
     * @return the command that should be executed when the user cancels
     */
    protected Command getCancelCommand() {
        return null;
    }

    /**
     * Reads a String from the console.
     * Only accepts String values that conform to isValidString.
     *
     * @return the selected integer value
     */
    private String readStringInput() {
        System.out.print(inputPrefix);
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {

            String enteredString = scanner.nextLine();

            // Cancel
            if (getCancelCommand() != null && enteredString.equalsIgnoreCase(cancelCharacter.toString())) {
                getCancelCommand().execute();
                break;
            }

            if (!isValidString(enteredString)) {
                // input String is not valid
                System.out.println(getValidationMessage());
                System.out.print(inputPrefix);
                continue;
            }

            // input String is valid
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
        return !s.isEmpty();
    }

    /**
     * Override this method to use a custom message when an invalid String has been entered.
     *
     * @return the validation message
     */
    protected String getValidationMessage() {
        return Config.resourceBundle.getString("utilities.view.StringInputView.ValidationMessage");
    }
}
