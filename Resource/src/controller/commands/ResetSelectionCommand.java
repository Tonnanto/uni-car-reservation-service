package controller.commands;

public class ResetSelectionCommand extends ResourceServiceCommand {
    @Override
    public void execute() {
        receiver.setResource(null);
    }

    @Override
    public String getDescription() {
        return "Reset Selection";
    }
}
