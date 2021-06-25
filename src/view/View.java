package view;

/**
 * This class handles user interaction with the console.
 * A message and multiple selection options can be displayed.
 * The user can select one of the options by entering the desired number into the console.
 */
public abstract class View {

    protected final static String separator = "----------------------------------------------------";
    protected final static String inputPrefix = ">>> ";

    protected abstract String getMessage();

    public void display() {
        System.out.println(separator);
        System.out.println(getMessage());
        System.out.println();
    }
}
