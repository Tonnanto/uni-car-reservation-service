package view;

import controller.Command;

import java.util.List;
import java.util.Scanner;

/**
 * This View allows the user to select between multiple options.
 * A message and multiple selection options will be displayed.
 * The user can select one of the options by entering the desired number into the console.
 * The selected number can be handed to a command.
 */
public abstract class SelectionView extends View {

    /**
     * This method displays the view, reads the user input, and executes the given command.
     */
    @Override
    public void display() {
        // display view
        super.display();

        for (int i = 0; i < getCommands().size(); i++) {
            System.out.printf("[%s] %s\n", i + 1, getCommands().get(i).getDescription());
        }

        // read user input
        int inputInteger = readIntInput();

        // execute command
        getCommands().get(inputInteger - 1).execute();
    }

    /**
     * @return the commands the user can choose from
     */
    protected abstract List<Command> getCommands();

    /**
     * Reads an integer from the console.
     * Only accepts integer values in the range of the selectionOptions.
     *
     * @return the selected integer value
     */
    protected int readIntInput() {

        System.out.print(inputPrefix);
        Scanner scanner = new Scanner(System.in);
        int optionCount = getCommands().size();

        while(scanner.hasNext()) {
            if(!scanner.hasNextInt()) {
                // input is not a number
                System.out.println("Please enter a number between 1 and " + optionCount);
                System.out.print(inputPrefix);
                scanner.next();
                continue;
            }

            int enteredNumber = scanner.nextInt();

            if (enteredNumber <= 0 || enteredNumber > optionCount) {
                // input number is out of valid range
                System.out.println("Please enter a number between 1 and " + optionCount);
                System.out.print(inputPrefix);
                continue;
            }

            // input number is valid
            return enteredNumber;
        }

        // this return statement should never be reached. -1 indicates an error
        return -1;
    }
}