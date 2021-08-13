package view;

public class ContentNotFoundView extends View {
    @Override
    protected String getMessage() {
        return "The content you were trying to open was not found.";
    }
}
