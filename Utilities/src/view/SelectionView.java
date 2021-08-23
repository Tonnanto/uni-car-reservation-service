package view;

import controller.Command;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * This View allows the user to select between multiple commands.
 * A message and multiple commands will be displayed.
 * The user can execute one of the commands by entering the desired number into the console.
 */
public abstract class SelectionView extends View {

    /**
     * This method displays the view, reads the user input, and executes the given command.
     */
    @Override
    public void display() {
        // display view
        System.out.println(separator);
        System.out.println(getMessage());

        int commandNumber = 1;
        for (Command command : getCommands()) {
            if (command == null) {
                System.out.println();
                continue;
            }

            System.out.printf("[%s] %s\n", commandNumber++, command.getDescription());
        }

        // read user input
        int inputInteger = readIntInput();

        // execute command
        getFilteredCommands().get(inputInteger - 1).execute();
    }

    /**
     * Override this method to decide which commands should be available to the user when this view gets displayed.
     * Add null to the list to add an empty line between commands.
     *
     * @return the list of commands that the view will display
     */
    protected abstract List<Command> getCommands();

    /**
     * Reads an integer from the console.
     * Only accepts integer values in the range of the selectionOptions.
     *
     * @return the selected integer value
     */
    private int readIntInput() {

        System.out.print(inputPrefix);
        Scanner scanner = new Scanner(System.in);
        long optionCount = getFilteredCommands().size();

        while (scanner.hasNext()) {
            if (!scanner.hasNextInt()) {
                // input is not a number
                System.out.println(Language.resourceBundle.getString("utilities.view.SelectionView.readIntInput") + optionCount);
                System.out.print(inputPrefix);
                scanner.next();
                continue;
            }

            int enteredNumber = scanner.nextInt();

            if (enteredNumber <= 0 || enteredNumber > optionCount) {
                // input number is out of valid range
                System.out.println(Language.resourceBundle.getString("utilities.view.SelectionView.readIntInput") + optionCount);
                System.out.print(inputPrefix);
                continue;
            }

            // input number is valid
            return enteredNumber;
        }

        // this return statement should never be reached. -1 indicates an error
        return -1;
    }

    /**
     * Filters null Objects from getCommands()
     */
    private List<Command> getFilteredCommands() {
        return getCommands().stream().filter(Objects::nonNull).collect(Collectors.toList());
    }
}
