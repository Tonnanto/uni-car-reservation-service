package controller.commands;

public class ResetSelectionCommand extends ResourceServiceCommand {
    @Override
    public void execute() {
        receiver.resetSelection();
    }

    @Override
    public String getDescription() {
        return "Reset Selection";
    }
}
